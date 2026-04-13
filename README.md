# Life Logger Ktor (Simple Setup)

これは、提供された構成 (`libs.versions.toml` や `build.gradle.kts`) を基に構築したシンプルな Ktor サーバーのプロジェクトです。
データベースの接続や認証機能は含まれておらず、疎通確認用のシンプルなエンドポイントのみを提供します。

## 起動方法

ターミナル（コマンドプロンプト）を開き、プロジェクトのルートディレクトリで以下のコマンドを実行します。

```bash
./gradlew run
```

> **Note:**
> 起動時に `-Dio.netty.bootstrap.extensions` などの `DEBUG` レベルのログが多数表示されることがありますが、これらはエラーではありません。
> 最後に `[DefaultDispatcher-worker-1] INFO io.ktor.server.Application -- Responding at http://0.0.0.0:8080` と表示されれば、サーバーは正常に起動しています。

## 動作確認手順

サーバーが起動した状態で、以下のいずれかの方法でエンドポイントにアクセスし、レスポンスを確認します。

### 方法1: curl コマンドを使用する (推奨)
別のターミナルウィンドウを開き、以下のコマンドを実行します。

```bash
curl http://localhost:8080/greeting
```

**期待される結果:**
```json
{"msg":"hello"}
```

### 方法2: ブラウザを使用する
Webブラウザを開き、アドレスバーに以下のURLを入力してアクセスします。

`http://localhost:8080/greeting`

画面上に `{"msg":"hello"}` と表示されれば成功です。
