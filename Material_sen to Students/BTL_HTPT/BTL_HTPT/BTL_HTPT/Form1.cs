using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Configuration;
using System.Data.SqlClient;

namespace BTL_HTPT
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection con;

        private void Form1_Load(object sender, EventArgs e)
        {
            string conString = ConfigurationManager.ConnectionStrings["btl"].ConnectionString.ToString();
            con = new SqlConnection(conString);
            con.Open();
            hienThi();

        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            con.Close();
        }

        public void hienThi()
        {
            string sqlSELECT = "SELECT * FROM Categories";
            SqlCommand cmd = new SqlCommand(sqlSELECT, con);
            SqlDataReader dr = cmd.ExecuteReader();
            DataTable dt = new DataTable();
            dt.Load(dr);
            ds.DataSource = dt;

        }

        private void Them_Click(object sender, EventArgs e)
        {
            string sqlINSERT = "INSERT INTO Categories VALUES(@CategoryId,@DisplayOrder,@CategoryName,@CategoryDesc,@ParentCategoryId,@Url,@CategoryStatusId,@ImageIcon,@CrUserId,@CrDateTime)";
            SqlCommand cmd = new SqlCommand(sqlINSERT, con);
            cmd.Parameters.AddWithValue("CategoryId", txtID.Text);
            cmd.Parameters.AddWithValue("DisplayOrder", txtOrder.Text);
            cmd.Parameters.AddWithValue("CategoryName", txtName.Text);
            cmd.Parameters.AddWithValue("CategoryDesc", txtDes.Text);
            cmd.Parameters.AddWithValue("ParentCategoryId", txtPID.Text);
            cmd.Parameters.AddWithValue("Url", txtUrl.Text);
            cmd.Parameters.AddWithValue("CategoryStatusId", txtSID.Text);
            cmd.Parameters.AddWithValue("ImageIcon", txtIcon.Text);
            cmd.Parameters.AddWithValue("CrUserId", txtUID.Text);
            DateTime date = DateTime.Now;
            cmd.Parameters.AddWithValue("CrDateTime", date);
            cmd.ExecuteNonQuery();
            hienThi();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string sqlDELETE = "DELETE FROM Categories WHERE CategoryId=@CategoryId";
            SqlCommand cmd = new SqlCommand(sqlDELETE, con);
            cmd.Parameters.AddWithValue("CategoryId", txtID.Text);
            cmd.ExecuteNonQuery();
            hienThi();
        }
    }
}

