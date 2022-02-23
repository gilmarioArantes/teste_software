FROM ubuntu

MAINTAINER Gilmar Arantes <gilmar.arantes@gmail.com>

RUN apt-get update

RUN apt-get install -y nginx

ADD exemplo /etc/nginx/sites-enabled/default

RUN ln -sf /dev/stdout /var/log/nginx/access.log
RUN ln -sf /dev/stderr /var/log/nginx/error.log

EXPOSE 8080

CMD ["nginx","-g","daemon off;"]
