# Bài dự báo thời tiết XML/XSD/XSLT

Repository có các bài Visual Studio sau:

- `DuBaoThoiTiet.sln`: ứng dụng Console.
- `WindowsForms/DuBaoThoiTiet_WindowsForms.sln`: ứng dụng Windows Forms có giao diện, nút kiểm tra XML và vùng hiển thị kết quả.
- `SanXuatDienThoai_WindowsForms/SanXuatDienThoai_WindowsForms.sln`: bài sản xuất điện thoại theo đề kiểm tra mới, chạy bằng Windows Forms.
- `BangGiaXe_WindowsForms/BangGiaXe_WindowsForms.sln`: bài bảng giá xe của đề KTTX1 C2, chạy bằng Windows Forms.
- `QuanLyThietBi_Android`: ứng dụng Android Java quản lý thiết bị bằng Material 3, RecyclerView và Room Database.
- `QuanLyThietBi_Android.zip`: file ZIP source Android Studio để tải trực tiếp.

## Chạy bản Windows Forms

1. Mở `WindowsForms/DuBaoThoiTiet_WindowsForms.sln` bằng Visual Studio 2022.
2. Nếu Visual Studio hỏi workload, cài **.NET desktop development**.
3. Nhấn `F5` hoặc `Ctrl+F5` để chạy.

## Chạy bản Console

1. Mở file `DuBaoThoiTiet.sln` bằng Visual Studio 2022.
2. Nếu Visual Studio hỏi workload, cài **.NET desktop development**.
3. Trong Solution Explorer, mở project `DuBaoThoiTiet` để xem các file XML, XSD, XSLT và C#.
4. Nhấn `Ctrl+F5` để chạy.
5. Chương trình kiểm tra XML theo XSD rồi tạo `DuBaoThoiTiet.html` trong thư mục `bin\Debug\net8.0`.
6. Mở file HTML đó bằng trình duyệt để xem bảng dự báo và biểu tượng thời tiết.

Không cần cài NuGet package. Project dùng các lớp có sẵn trong .NET 8: `XmlReader`, `XmlSchema` và `XslCompiledTransform`.
