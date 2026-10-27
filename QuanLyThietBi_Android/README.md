# Quản lý thiết bị - Android Java

Ứng dụng Android Studio đáp ứng bài quản lý thiết bị bằng Java, Material 3, RecyclerView và Room Database.

## Chức năng

- Tiêu đề **QUẢN LÝ THIẾT BỊ**, hai ô nhập tên thiết bị và nhà sản xuất.
- Danh sách RecyclerView, làm nổi bật dòng đang được chọn.
- **THÊM**: kiểm tra dữ liệu, lưu Room, cập nhật danh sách và xóa vùng nhập.
- Click một dòng: đưa dữ liệu lên vùng nhập và lưu ID cần sửa.
- **SỬA**: chuyển sang **CẬP NHẬT**; lần nhấn tiếp theo cập nhật đúng bản ghi trong Room.
- Room dùng Entity `ThietBi`, `ThietBiDao`, `AppDatabase` và LiveData để danh sách tự cập nhật.
- Có giao diện sáng/tối theo Material 3.

## Mở và chạy

1. Mở thư mục `QuanLyThietBi_Android` bằng Android Studio.
2. Chờ Gradle Sync tải các dependency.
3. Chọn máy ảo hoặc điện thoại Android API 24 trở lên.
4. Nhấn **Run app**.

Project dùng Android Gradle Plugin 8.7.3, Gradle 8.9, Java 17 và compile SDK 35.

## Kiểm thử

- Chạy `./gradlew assembleDebug` để build APK debug.
- Chạy `./gradlew connectedAndroidTest` khi có emulator/thiết bị để kiểm tra thao tác thêm và sửa của Room DAO.
