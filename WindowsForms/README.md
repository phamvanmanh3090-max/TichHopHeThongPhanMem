# Dự báo thời tiết - Windows Forms

## Cách mở

1. Giải nén file ZIP.
2. Mở `DuBaoThoiTiet_WindowsForms.sln` bằng Visual Studio 2022.
3. Nếu Visual Studio yêu cầu cài workload, chọn **.NET desktop development**.
4. Nhấn `F5` hoặc `Ctrl+F5` để chạy.

## Chức năng

- Tự động kiểm tra `DuBaoThoiTiet.xml` theo `DuBaoThoiTiet.xsd` khi mở chương trình.
- Chuyển XML thành HTML bằng `DuBaoThoiTiet.xsl`.
- Hiển thị bảng dự báo và ảnh thời tiết ngay trong Windows Forms.
- Nút **Kiểm tra XML** cho biết dữ liệu có thỏa các ràng buộc XSD hay không.
- Nút **Tạo và xem HTML** tạo lại giao diện sau khi dữ liệu XML thay đổi.

Project dùng .NET 8 và các thư viện có sẵn của .NET, không cần cài NuGet package.
