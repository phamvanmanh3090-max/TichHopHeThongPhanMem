using System.Xml;
using System.Xml.Schema;
using System.Xml.Xsl;

namespace BangGiaXe.WinForms;

public partial class MainForm : Form
{
    private readonly string _fileXml;
    private readonly string _fileXsd;
    private readonly string _fileXsl;
    private readonly string _fileHtml;

    public MainForm()
    {
        InitializeComponent();

        string thuMuc = AppContext.BaseDirectory;
        _fileXml = Path.Combine(thuMuc, "BangGiaXe.xml");
        _fileXsd = Path.Combine(thuMuc, "BangGiaXe.xsd");
        _fileXsl = Path.Combine(thuMuc, "BangGiaXe.xsl");
        _fileHtml = Path.Combine(thuMuc, "BangGiaXe.html");
    }

    protected override void OnShown(EventArgs e)
    {
        base.OnShown(e);
        TaoVaHienThiHtml();
    }

    private void BtnKiemTra_Click(object? sender, EventArgs e)
    {
        bool hopLe = KiemTraXml(out string thongBao);
        HienThiTrangThai(thongBao, hopLe ? Color.DarkGreen : Color.DarkRed);

        MessageBox.Show(
            thongBao,
            hopLe ? "XML hợp lệ" : "XML không hợp lệ",
            MessageBoxButtons.OK,
            hopLe ? MessageBoxIcon.Information : MessageBoxIcon.Error);
    }

    private void BtnTaoHtml_Click(object? sender, EventArgs e)
    {
        TaoVaHienThiHtml();
    }

    private bool KiemTraXml(out string thongBao)
    {
        var loi = new List<string>();

        try
        {
            var settings = new XmlReaderSettings
            {
                ValidationType = ValidationType.Schema,
                DtdProcessing = DtdProcessing.Prohibit
            };

            settings.Schemas.Add(null, _fileXsd);
            settings.ValidationFlags |= XmlSchemaValidationFlags.ReportValidationWarnings;
            settings.ValidationEventHandler += (_, e) => loi.Add(e.Message);

            using XmlReader reader = XmlReader.Create(_fileXml, settings);
            while (reader.Read())
            {
                // Đọc toàn bộ XML để XmlReader kiểm tra mọi phần tử theo XSD.
            }
        }
        catch (Exception ex)
        {
            loi.Add(ex.Message);
        }

        if (loi.Count == 0)
        {
            thongBao = "XML hợp lệ theo lược đồ XSD.";
            return true;
        }

        thongBao = "Phát hiện lỗi:\n" + string.Join("\n", loi);
        return false;
    }

    private void TaoVaHienThiHtml()
    {
        if (!KiemTraXml(out string thongBao))
        {
            HienThiTrangThai(thongBao, Color.DarkRed);
            return;
        }

        try
        {
            var xslt = new XslCompiledTransform();
            xslt.Load(_fileXsl);
            xslt.Transform(_fileXml, _fileHtml);

            trinhDuyet.Navigate(new Uri(_fileHtml).AbsoluteUri);
            HienThiTrangThai(
                "XML hợp lệ — đã tạo và hiển thị BangGiaXe.html.",
                Color.DarkGreen);
        }
        catch (Exception ex)
        {
            HienThiTrangThai("Không thể tạo HTML: " + ex.Message, Color.DarkRed);
        }
    }

    private void HienThiTrangThai(string noiDung, Color mau)
    {
        lblTrangThai.Text = noiDung.Replace(Environment.NewLine, " ");
        lblTrangThai.ForeColor = mau;
    }
}
