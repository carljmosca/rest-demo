keytool -genkey -noprompt \
    -alias tomcat \
    -dname "CN=tomcat.secure, OU=Virginia, O=Carl J. Mosca, C=US" \
    -keystore ../resources/keystore.jks \
    -storepass changeit \
    -storetype PKCS12 -keyalg RSA -keysize 2048 \
    -keypass changeit -validity 3650
cp ../resources/keystore.jks ../docker/keystore.jks
openssl pkcs12 -in ../resources/keystore.jks -passin pass:changeit \
    -nokeys -out ../docker/certs/tomcat.secure.crt
openssl pkcs12 -in ../resources/keystore.jks -passin pass:changeit \
    -nocerts -nodes  -out ../docker/keys/tomcat.secure.key