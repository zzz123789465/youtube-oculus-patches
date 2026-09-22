# YouTube Oculus Patches

這是一個針對 Meta Quest 版 YouTube VR 的實驗性開源修補專案，可搭配 Morphe 使用，但不是 Morphe 官方專案，也未獲 Google 或 Morphe 背書。

[English README](README.md) · [完整安裝說明](docs/INSTALLATION.zh-TW.md) · [技術說明](docs/TECHNICAL.md)

> [!IMPORTANT]
> 本倉庫只發布 patch 原始碼與 Morphe patch bundle，不提供原版或預先修補好的 YouTube APK。請只使用你有權取得與備份的原始 APK。

## 加入 Morphe Manager

[將 YouTube Oculus Patches 加入 Morphe](https://morphe.software/add-source?github=zzz123789465/youtube-oculus-patches)

目前由 `dev` 分支發布測試版；在 Morphe Manager 的 patch source 設定中開啟 pre-release 才會看到。

## 支援版本

| 項目 | 值 |
| --- | --- |
| App | YouTube VR for Meta Quest |
| 套件名稱 | `com.google.android.apps.youtube.vr.oculus` |
| 版本 | `1.85.11` |
| versionCode | `18511000` |
| 架構 | `arm64-v8a` |
| 狀態 | Experimental |

Patch metadata 也會核對原始 APK 的 Google 簽章，避免套用到名稱相同但內容不同的 APK。

## 修補內容

### Block video ads

停用兩條播放器內廣告路徑：

1. 廣告 trigger 與 ping 派送。
2. `PlayerBytes` 片頭／片中廣告版面建立。

這兩個 fingerprint 取自 Morphe 既有的手機版 YouTube 廣告 patch，並已確認在 YouTube VR `1.85.11` 的五個 DEX 中各自只命中一個方法。

研究階段曾加入第三個同步 `AdBreak` 強制回傳，但因完整播放回歸測試尚未完成，公開版刻意不包含該攔截點，降低黑畫面、持續載入或重複請求的風險。

## 驗證狀態

- 研究版完成五個 DEX、27,462 個類別與跨 DEX 類別階層驗證。
- 修補版已在 Android 14／API 34 的 Meta Quest 3S 冷啟動成功。
- OpenXR 接受本機重新簽章的 APK；啟動檢查期間未發現崩潰、ANR 或 DEX verifier 錯誤。
- 登入、一般影片、180°／360° 影片與實際廣告投放仍需要更多使用者測試。

請在 [GitHub Issues](https://github.com/zzz123789465/youtube-oculus-patches/issues) 回報結果，但不要附上任何 APK。

## 安裝

完整步驟與疑難排解請看 [docs/INSTALLATION.zh-TW.md](docs/INSTALLATION.zh-TW.md)。

## 授權與聲明

本專案採用 [GPL-3.0](LICENSE)，並受 [NOTICE](NOTICE) 中的附加條款約束。程式中的 Morphe fingerprint 保留原始來源標示；「Morphe」只用於描述相容性，不代表官方開發或背書。
