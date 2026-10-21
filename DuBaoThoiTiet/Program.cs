using System.Xml;
using System.Xml.Schema;
using System.Xml.Xsl;

namespace DuBaoThoiTiet;

internal static class Program
{
    private static bool _hopLe = true;

    private static void Main()
    {
        Console.OutputEncoding = System.Text.Encoding.UTF8;

        string thuMuc = AppContext.BaseDirectory;
        string fileXml = Path.Combine(thuMuc, "DuBaoThoiTiet.xml");
        string fileXsd = Path.Combine(thuMuc, "DuBaoThoiTiet.xsd");
        string fileXsl = Path.Combine(thuMuc, "DuBaoThoiTiet.xsl");
        string fileHtml = Path.Combine(thuMuc, "DuBaoThoiTiet.html");

        KiemTraXml(fileXml, fileXsd);

        if (!_hopLe)
        {
            Console.WriteLine("XML không hợp lệ. Không tạo file HTML.");
            Console.WriteLine("Nhấn phím bất kỳ để kết thúc...");
            Console.ReadKey();
            return;
        }

        ChuyenXmlSangHtml(fileXml, fileXsl, fileHtml);
        Console.WriteLine("XML hợp lệ theo lược đồ XSD.");
        Console.WriteLine($"Đã tạo HTML: {fileHtml}");
        Console.WriteLine("Mở file HTML trên bằng trình duyệt để xem kết quả.");
        Console.WriteLine("Nhấn phím bất kỳ để kết thúc...");
        Console.ReadKey();
    }

    private static void KiemTraXml(string fileXml, string fileXsd)
    {
        var settings = new XmlReaderSettings
        {
            ValidationType = ValidationType.Schema
        };

        settings.Schemas.Add(null, fileXsd);
        settings.ValidationEventHandler += BaoLoiXacThuc;

        using XmlReader reader = XmlReader.Create(fileXml, settings);
        while (reader.Read())
        {
            // Đọc toàn bộ tài liệu để kích hoạt kiểm tra XSD.
        }
    }

    private static void BaoLoiXacThuc(object? sender, ValidationEventArgs e)
    {
        _hopLe = false;
        Console.WriteLine($"Lỗi XSD: {e.Message}");
    }

    private static void ChuyenXmlSangHtml(
        string fileXml,
        string fileXsl,
        string fileHtml)
    {
        var xslt = new XslCompiledTransform();
        xslt.Load(fileXsl);
        xslt.Transform(fileXml, fileHtml);
    }
}
