$(document).ready(function(){  
    const urlRequest = "//www.devmedia.com.br/inc/download/controller/download_controller.php";
    var modaisAbertos = 0;
    var nocache = 2;

    data = {
        util: null,
        feedback:null,
        idcomp: null,
        acao: "salvarFeedback"
    }

    $("body").on("click",".feedback-close-icon",function(){
        let idcomp = $("#download-feedback-modal [name='idcomp']").val();
        $.ajax({
            url:urlRequest,
            method:"POST",
            data:{acao: "ocultarFeedback", idcomp: idcomp},
            success:function(){
                fecharFeedbackModal(function(){
                    obterFeedback();
                });
            },
            error:function(res){
                console.error(res);
                fecharFeedbackModal();
            }
        });
    });

    $("body").on("click", ".feedback-like-icon", function(){
        data.util = parseInt($(this).data("like"));
        $(".feedback-like-icon").removeClass("active").addClass("disabled");
        $(this).removeClass("disabled").addClass("active");
        $(".feedback-input-area").slideDown(200);

        if(data.util == -1){
            $(".feedback-optional-label").slideUp(200);
        }else{
            $(".feedback-optional-label").slideDown(200);
        }
    });

    $("body").on("change", ".feedback-input-area textarea", function(){
        $(this).removeClass("feedback-required");
    });

    $("body").on("submit", "#download-feedback-modal", function(e){
        e.preventDefault();
        data.idcomp = $(this).find("[name='idcomp']").val();
        if(validarFeedback()){
            $.ajax({
                url: urlRequest,
                method: "POST",
                data: data,
                success:function(){
                    fecharFeedbackModal(function(){
                        obterFeedback();
                    });
                },
                error:function(res){
                    console.error(res);
                    fecharFeedbackModal();
                }
            })
        }
    });

    function validarFeedback(){
        var textarea = $(".feedback-input-area textarea");
        data.feedback = textarea.val();
        if(data.util == -1){
            if(data.feedback.length == 0){
                textarea.addClass("feedback-required");
                return false;
            }
        }
        textarea.removeClass("feedback-required");
        return true;
    }

    function fecharFeedbackModal(callback){
        $("#download-feedback-modal").removeClass("active").delay(200).queue(function(){
            data.util= null;
            data.feedback = null;
            data.idcomp= null;

            $("#download-feedback-modal").remove();
            if(typeof callback == "function"){
                callback();
            }

            if(modaisAbertos == 2){
                setCookieFeedback(2);
            }

            
        });
    }

    function obterFeedback(){
        if(modaisAbertos < 2){
            $.ajax({
                url: urlRequest,
                method: "POST",
                data: {acao: "verificarFeedback"},
                success:function(res){
                    if(res.length > 0)
                    {
                        html = $(res);
                        if($("#cssfeedbackmodal").length  == 0){
                            $("head").append("<link href='//www.devmedia.com.br/download/css/style.css?"+nocache+"' id='cssfeedbackmodal' rel='stylesheet'>");
                            
                            $("#cssfeedbackmodal")[0].onload = function(){
                                renderiazarModal(html);
                            }
                        }else{
                            renderiazarModal(html);
                        }
                    }
                },
                error:function(res){
                    console.error(res);
                }
            });
        }
    }

    if(window.innerWidth > 768 || typeof window.orientation == "undefined"){
        if(!verificarCookieFeedback()) obterFeedback();
    }

    function renderiazarModal(modal){
        let html = $(modal);
        if(typeof html.attr("id") != "undefined"){
            $("body").append(html);

            setTimeout(function(){
                $("#download-feedback-modal").addClass("active");
            },1000);

            modaisAbertos++;
        }else{
            if (!verificarCookieFeedback()) {
                setCookieFeedback(1);
            }
        }
    }

    function setCookieFeedback(horas) {
        var d = new Date();
        d.setTime(d.getTime() + (horas * 60 * 60 * 1000));
        var expires = "expires="+d.toUTCString();
        document.cookie = "downloadFeedback" + "=" + "true" + ";" + expires + ";path=/";
    }
      
    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    function verificarCookieFeedback() {
        var cookie = getCookie("downloadFeedback");
        if (cookie != "") {
            return true;
        }
        return false;
    }
});
