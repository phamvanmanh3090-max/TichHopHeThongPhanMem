# Bảng giá xe - Windows Forms

Đây là bài làm theo đề `KTTX1_C2.pdf`.

## Nội dung

- `BangGiaXe.xsd`: lược đồ và các ràng buộc của câu 1.
- `BangGiaXe.xml`: dữ liệu 3 hãng, mỗi hãng 2 dòng xe của câu 2.
- `BangGiaXe.xsl`: giao diện bảng và ánh xạ logo của câu 3.
- `MainForm.cs`: kiểm tra XML theo XSD, chuyển XSLT sang HTML và hiển thị trong Windows Forms.

## Chạy bằng Visual Studio

1. Mở `BangGiaXe_WindowsForms.sln` bằng Visual Studio 2022.
2. Cài workload **.NET desktop development** nếu Visual Studio yêu cầu.
3. Nhấn `F5` hoặc `Ctrl+F5`.

Ứng dụng tự kiểm tra XML, tạo `BangGiaXe.html` và hiển thị kết quả. Project dùng .NET 8, không cần NuGet package.
