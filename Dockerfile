# Bazowy obraz
FROM selenium/standalone-chrome-debug:3.141.59-20210607

# Aktualizacja repozytoriów, instalacja JDK i Maven
USER root
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk maven

# Ustawienie zmiennej środowiskowej JAVA_HOME
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

# Ustawienie katalogu roboczego
WORKDIR /usr/src/mymaven

# Przeniesienie plików projektu do kontenera
COPY my-app/ .

# Uruchamianie testów
CMD ["mvn", "test"]
