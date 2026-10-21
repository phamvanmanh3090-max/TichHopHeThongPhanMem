# Sản xuất điện thoại - Windows Forms

Đây là bài làm theo đề `De_Kiem_Tra_Thuong_Xuyen_1_Tich_Hop_He_Thong.pdf`.

## Nội dung

- `SanXuatDienThoai.xsd`: lược đồ và các ràng buộc của câu 1.
- `SanXuatDienThoai.xml`: dữ liệu 2 năm, mỗi năm 3 công ty của câu 2.
- `SanXuatDienThoai.xsl`: giao diện bảng và ánh xạ logo của câu 3.
- `MainForm.cs`: kiểm tra XML theo XSD, chuyển XSLT sang HTML và hiển thị trong Windows Forms.

## Chạy bằng Visual Studio

1. Mở `SanXuatDienThoai_WindowsForms.sln` bằng Visual Studio 2022.
2. Cài workload **.NET desktop development** nếu Visual Studio yêu cầu.
3. Nhấn `F5` hoặc `Ctrl+F5`.

Ứng dụng tự kiểm tra XML, tạo `SanXuatDienThoai.html` và hiển thị kết quả. Project dùng .NET 8, không cần NuGet package.
