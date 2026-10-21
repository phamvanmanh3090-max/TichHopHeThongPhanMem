# Chạy bài trong Visual Studio

1. Mở file `DuBaoThoiTiet.sln` bằng Visual Studio 2022.
2. Nếu Visual Studio hỏi workload, cài **.NET desktop development**.
3. Trong Solution Explorer, mở project `DuBaoThoiTiet` để xem các file XML, XSD, XSLT và C#.
4. Nhấn `Ctrl+F5` để chạy.
5. Chương trình kiểm tra XML theo XSD rồi tạo `DuBaoThoiTiet.html` trong thư mục `bin\Debug\net8.0`.
6. Mở file HTML đó bằng trình duyệt để xem bảng dự báo và biểu tượng thời tiết.

Không cần cài NuGet package. Project dùng các lớp có sẵn trong .NET 8: `XmlReader`, `XmlSchema` và `XslCompiledTransform`.
