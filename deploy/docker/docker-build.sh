IMAGE_NAME="speaking-snail"

# jarファイルをコピー
cp ../../target/speakingsnail-0.0.1-SNAPSHOT.jar ./jar

# イメージをビルド
docker build -t ${IMAGE_NAME} .