###########################################
### Javaアプリケーションのイメージ
###########################################
JAVA_IMAGE_NAME="speaking-snail"

# jarファイルをコピー
cp ../../target/speakingsnail-0.0.1-SNAPSHOT.jar ./java/jar

# イメージをビルド
docker build -t ${JAVA_IMAGE_NAME} ./java

###########################################
### データベースのイメージ
###########################################
DB_IMAGE_NAME="snail-db"

# イメージをビルド
docker build -t ${DB_IMAGE_NAME} ./db