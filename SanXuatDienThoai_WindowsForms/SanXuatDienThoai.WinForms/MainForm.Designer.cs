#nullable enable

namespace SanXuatDienThoai.WinForms;

partial class MainForm
{
    private System.ComponentModel.IContainer? components = null;
    private TableLayoutPanel boCucChinh = null!;
    private Label lblTieuDe = null!;
    private FlowLayoutPanel thanhCongCu = null!;
    private Button btnKiemTra = null!;
    private Button btnTaoHtml = null!;
    private Label lblTrangThai = null!;
    private WebBrowser trinhDuyet = null!;

    protected override void Dispose(bool disposing)
    {
        if (disposing)
        {
            components?.Dispose();
        }

        base.Dispose(disposing);
    }

    private void InitializeComponent()
    {
        boCucChinh = new TableLayoutPanel();
        lblTieuDe = new Label();
        thanhCongCu = new FlowLayoutPanel();
        btnKiemTra = new Button();
        btnTaoHtml = new Button();
        lblTrangThai = new Label();
        trinhDuyet = new WebBrowser();
        boCucChinh.SuspendLayout();
        thanhCongCu.SuspendLayout();
        SuspendLayout();

        boCucChinh.ColumnCount = 1;
        boCucChinh.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100F));
        boCucChinh.Controls.Add(lblTieuDe, 0, 0);
        boCucChinh.Controls.Add(thanhCongCu, 0, 1);
        boCucChinh.Controls.Add(trinhDuyet, 0, 2);
        boCucChinh.Dock = DockStyle.Fill;
        boCucChinh.RowCount = 3;
        boCucChinh.RowStyles.Add(new RowStyle(SizeType.Absolute, 68F));
        boCucChinh.RowStyles.Add(new RowStyle(SizeType.Absolute, 58F));
        boCucChinh.RowStyles.Add(new RowStyle(SizeType.Percent, 100F));

        lblTieuDe.BackColor = Color.FromArgb(82, 140, 0);
        lblTieuDe.Dock = DockStyle.Fill;
        lblTieuDe.Font = new Font("Segoe UI", 20F, FontStyle.Bold);
        lblTieuDe.ForeColor = Color.White;
        lblTieuDe.Text = "THỊ TRƯỜNG SẢN XUẤT ĐIỆN THOẠI";
        lblTieuDe.TextAlign = ContentAlignment.MiddleCenter;

        thanhCongCu.BackColor = Color.WhiteSmoke;
        thanhCongCu.Controls.Add(btnKiemTra);
        thanhCongCu.Controls.Add(btnTaoHtml);
        thanhCongCu.Controls.Add(lblTrangThai);
        thanhCongCu.Dock = DockStyle.Fill;
        thanhCongCu.Padding = new Padding(12, 9, 12, 8);
        thanhCongCu.WrapContents = false;

        btnKiemTra.AutoSize = true;
        btnKiemTra.Font = new Font("Segoe UI", 10F);
        btnKiemTra.Margin = new Padding(0, 0, 10, 0);
        btnKiemTra.Padding = new Padding(10, 3, 10, 3);
        btnKiemTra.Text = "Kiểm tra XML";
        btnKiemTra.UseVisualStyleBackColor = true;
        btnKiemTra.Click += BtnKiemTra_Click;

        btnTaoHtml.AutoSize = true;
        btnTaoHtml.Font = new Font("Segoe UI", 10F);
        btnTaoHtml.Margin = new Padding(0, 0, 18, 0);
        btnTaoHtml.Padding = new Padding(10, 3, 10, 3);
        btnTaoHtml.Text = "Tạo và xem HTML";
        btnTaoHtml.UseVisualStyleBackColor = true;
        btnTaoHtml.Click += BtnTaoHtml_Click;

        lblTrangThai.AutoEllipsis = true;
        lblTrangThai.Font = new Font("Segoe UI", 10F);
        lblTrangThai.Margin = new Padding(0, 8, 0, 0);
        lblTrangThai.Size = new Size(560, 25);
        lblTrangThai.Text = "Đang tải dữ liệu...";
        lblTrangThai.TextAlign = ContentAlignment.MiddleLeft;

        trinhDuyet.Dock = DockStyle.Fill;
        trinhDuyet.ScriptErrorsSuppressed = true;

        AutoScaleDimensions = new SizeF(7F, 15F);
        AutoScaleMode = AutoScaleMode.Font;
        ClientSize = new Size(1040, 760);
        Controls.Add(boCucChinh);
        MinimumSize = new Size(850, 600);
        StartPosition = FormStartPosition.CenterScreen;
        Text = "Sản xuất điện thoại - XML, XSD và XSLT";
        WindowState = FormWindowState.Maximized;
        boCucChinh.ResumeLayout(false);
        thanhCongCu.ResumeLayout(false);
        thanhCongCu.PerformLayout();
        ResumeLayout(false);
    }
}
