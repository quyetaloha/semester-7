from requests import Session
from lxml import html
from config import USERNAME, PASSWORD


def main():
    session = Session()
    user_agent = "Mozilla/5.0 (X11; Linux x86_64)" \
                 "AppleWebKit/537.36 (KHTML, like Gecko)" \
                 "Chrome/71.0.3578.98 Safari/537.36"

    # Login
    login_headers = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
        "Accept-Encoding": "gzip, deflate",
        "Accept-Language": "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5",
        "User-Agent": user_agent
    }
    login_page = "https://qldt.ptit.info/default.aspx?page=dangnhap"

    login_get = session.get(
        url=login_page,
        headers=login_headers
    )

    tree = html.fromstring(login_get.text)
    view_state = tree.xpath('//*[@id="__VIEWSTATE"]')[0].get('value')
    view_state_generator = tree.xpath('//*[@id="__VIEWSTATEGENERATOR"]')[0].get('value')

    login_data = {
        "__EVENTTARGET": "",
        "__EVENTARGUMENT": "",
        "__VIEWSTATE": view_state,
        "__VIEWSTATEGENERATOR": view_state_generator,
        "ctl00$ContentPlaceHolder1$ctl00$txtTaiKhoa": USERNAME,
        "ctl00$ContentPlaceHolder1$ctl00$txtMatKhau": PASSWORD,
        "ctl00$ContentPlaceHolder1$ctl00$btnDangNhap": "Đăng Nhập"
    }  # Login form

    session.post(
        url=login_page,
        headers=login_headers,
        data=login_data
    )  # Do login

    # Register
    reg_dangky_headers = {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate",
        "Accept-Language": "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5",
        "Content-Type": "text/plain; charset=UTF-8",
        "X-AjaxPro-Method": "DangKySelectedChange"
    }

    reg_url = "https://qldt.ptit.info/ajaxpro/EduSoft.Web.UC.DangKyMonHoc,EduSoft.Web.ashx"

    cac_he_thong_phan_tan = {
        "check": True,
        "maDK": "INT140501  01",
        "maMH": "INT1405",
        "tenMH": "Các hệ thống phân tán",
        "maNh": "01",
        "sotc": "3",
        "strSoTCHP": "0",
        "ngaythistr": "01/01/0001",
        "tietbd": "0",
        "sotiet": "0",
        "soTCTichLuyToiThieuMonYeuCau": "0",
        "choTrung": " ",
        "soTCMinMonYeuCau": "0",
        "maKhoiSinhVien": "D15HTTT"
    }

    reg_dk = session.post(
        url=reg_url,
        headers=reg_dangky_headers,
        json=cac_he_thong_phan_tan
    )

    reg_value = reg_dk.json()['value'].split("|")
    reg_data = {
        "isValidCoso": False,
        "isValidTKB": False,
        "maDK": reg_value[1],
        "maMH": reg_value[12],
        "sotc": reg_value[13],
        "tenMH": reg_value[14],
        "maNh": reg_value[15],
        "strsoTCHP": reg_value[16],
        "isCheck": "true",
        "oldMaDK": reg_value[4],
        "strngayThi": reg_value[25],
        "soTiet": reg_value[26],  # confusing ??
        "tietBD": reg_value[27],  # confusing ??
        "isMHDangKyCungKhoiSV": reg_value[35]
    }

    session.post(
        url=reg_url,
        headers={
            "Accept": "*/*",
            "Accept-Encoding": "gzip, deflate",
            "Accept-Language": "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5",
            "Content-Type": "text/plain; charset=UTF-8",
            "X-AjaxPro-Method": "LuuVaoKetQuaDangKy"
        },
        json=reg_data
    )

    session.post(
        url=reg_url,
        headers={
            "Accept": "*/*",
            "Accept-Encoding": "gzip, deflate",
            "Accept-Language": "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5",
            "Content-Type": "text/plain; charset=UTF-8",
            "X-AjaxPro-Method": "KiemTraTrungNhom"
        },
        json={}
    )
    session.post(
        url=reg_url,
        headers={
            "Accept": "*/*",
            "Accept-Encoding": "gzip, deflate",
            "Accept-Language": "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5",
            "Content-Type": "text/plain; charset=UTF-8",
            "X-AjaxPro-Method": "LuuDanhSachDangKy"
        },
        json={}
    )
    session.post(
        url=reg_url,
        headers={
            "Accept": "*/*",
            "Accept-Encoding": "gzip, deflate",
            "Accept-Language": "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5",
            "Content-Type": "text/plain; charset=UTF-8",
            "X-AjaxPro-Method": "LuuDanhSachDangKy_HopLe"
        },
        json={
            "isCheckSongHanh": False,
            "ChiaHP": False
        }
    )


if __name__ == '__main__':
    main()
