FROM anapsix/alpine-java
ENV LANG C.utf8
MAINTAINER liumoujie<25674959@qq.com>
ADD ./target/eureka-0.0.1-SNAPSHOT.jar /home
ENV RUN_ENV dev
ENV RUN_PROT 8761
WORKDIR /home
EXPOSE ${RUN_PROT}
CMD ["java","-jar","eureka-0.0.1-SNAPSHOT.jar","--spring.profiles.active=${RUN_ENV}"]