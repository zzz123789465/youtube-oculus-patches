# Meta Quest 安裝說明

## 準備項目

- 已開啟開發者模式與 USB 偵錯的 Meta Quest。
- 未修改的 YouTube VR `1.85.11` APK；套件為 `com.google.android.apps.youtube.vr.oculus`，versionCode 為 `18511000`。
- Morphe Manager 或 Morphe Desktop。
- 足夠的暫存空間；原始 APK 約 113 MB，解包與重建需要更多空間。

請只使用你有權取得與備份的 APK。本倉庫不提供 YouTube 程式檔。

## 使用 Morphe Manager

1. 加入 patch source：`https://morphe.software/add-source?github=zzz123789465/youtube-oculus-patches`。
2. Patch 尚在實驗階段時，請在來源設定中開啟 pre-release。
3. 選擇原始 YouTube VR `1.85.11` APK。
4. 勾選 **Block video ads** 並開始修補。
5. 匯出完成的 APK，再透過 ADB 或你平常使用的 Quest 側載工具安裝。

## 使用 Morphe Desktop

從本倉庫的 GitHub Release 下載 `.mpp` bundle，執行：

```text
java -jar morphe-desktop-<版本>-all.jar patch \
  --patches patches-<版本>.mpp \
  --out YouTubeVR_1.85.11_patched.apk \
  YouTube_1.85.11.apk
```

Desktop 與 bundle 的實際檔名會隨版本改變。

## 安裝到 Quest

修補後 APK 會使用不同簽章，不能直接覆蓋 Meta Quest Store 的官方版。移除 App 會同時清除本機資料與登入狀態。

```text
adb uninstall com.google.android.apps.youtube.vr.oculus
adb install YouTubeVR_1.85.11_patched.apk
```

安裝後從 Quest 應用程式庫或「不明來源」開啟 YouTube VR。請測試一般、180°、360° 影片、快轉、返回首頁，以及數部原本會出現片頭或片中廣告的影片。

## 疑難排解

- **`INSTALL_FAILED_UPDATE_INCOMPATIBLE`**：官方版仍在裝置上，需先移除。
- **顯示 APK 不相容**：確認套件、版本 `1.85.11`、versionCode `18511000`、ARM64 架構與原始 Google 簽章。
- **黑畫面或持續載入**：先強制停止並重新開啟一次，再擷取 `adb logcat` 到 GitHub Issue 回報；請勿上傳 APK。
- **恢復官方版**：移除修補版，再從 Meta Quest Store 重新安裝 YouTube VR。

## 安全提醒

優先使用本倉庫 GitHub Actions release workflow 建置的 bundle，並在可用時核對 release provenance／attestation。不要安裝來路不明的預先修補 APK。
