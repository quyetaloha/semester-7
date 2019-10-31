package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nguoi;
import model.NguoiDung;
import model.Phong;

public class ClientControl implements Key {

    //su dung ham subString(1);
    private NguoiDung nguoiDung;
    private Socket socket = null;
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public ClientControl(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public NguoiDung checkLoginNguoiDung() {
        try {
            os.writeObject(LOGIN);
            String nhan = (String) is.readObject();
            System.out.println(nhan);
            System.out.println("Gửi dữ liệu người dùng cho server.Đợi server kiểm tra...");
            os.writeObject(nguoiDung);
            NguoiDung nd = (NguoiDung) is.readObject();
            if (nd != null) {
                return nd;
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public NguoiDung dangKyControl() {
        try {
            System.out.println("Client gửi yêu cầu đăng ký đến Server");
            os.writeObject(DANGKY);
            String nhan = (String) is.readObject();
            System.out.println(nhan);
            System.out.println("Client gửi thông tín đăng ký đến Server, đợi server kiểm tra... ");
            os.writeObject(nguoiDung);
            NguoiDung nd = (NguoiDung) is.readObject();
            return nd;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Phong> getListPhong() {
        try {
            os.writeObject(DS_PHONG);
            String nhan = (String) is.readObject();
            System.out.println(nhan);
            Object obj = is.readObject();
            if (obj instanceof ArrayList) {
                return (ArrayList<Phong>) obj;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Nguoi> getDanhSachBanBe() {
        try {
            os.writeObject(DS_BANBE);
            os.writeObject(nguoiDung.getIdNguoiDung());
            System.out.println(is.readObject());
            Object obj = is.readObject();
            if (obj instanceof ArrayList) {
                return (ArrayList<Nguoi>) obj;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Nguoi> getDanhSachTopServer() {
        try {
            os.writeObject(TOP_SERVER);
            System.out.println(is.readObject());
            Object obj = is.readObject();
            if (obj instanceof ArrayList) {
                return (ArrayList<Nguoi>) obj;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void dangXuat() {
        try {
            os.writeObject(DANG_XUAT);
            os.writeObject(nguoiDung);
            System.out.println((String) is.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateNguoiDung() {
        try {
            os.writeObject(UPDATE);
            os.writeObject(nguoiDung);
            String nhan = (String) is.readObject();
            System.out.println(nhan);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Phong timKiemPhong(int soPhong) {
        try {
            os.writeObject(SEARCH_P);
            os.writeObject(soPhong);
            Phong phong = (Phong) is.readObject();
            if (phong != null) {
                return phong;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Phong taoPhong(int soTien) {
        try {
            String nhan;
            os.writeObject(TAO_P);
            os.writeObject(soTien);
            os.writeObject(nguoiDung);
            Phong phong = (Phong) is.readObject();
            nhan = (String) is.readObject();
            System.out.println(nhan);
            return phong;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void xoaNguoiChoiKhoiDanhSachPhong(Phong phong) {
        String nhan;
        try {
            os.writeObject(XOA_NGUOI_DUNG);
            os.writeObject(nguoiDung);
            os.writeObject(phong);
            nhan = (String) is.readObject();
            System.out.println(nhan);
        } catch (IOException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkThayDoiNguoiChoiTrongPhong(Phong p) {
        String nhan;
        try {
            os.writeObject(KIEM_TRA_THAY_DOI);
            os.writeObject(p);
            int x = (int) is.readObject();
            nhan = (String) is.readObject();
            System.out.println(nhan);
            if (x == 1) {
                return true;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public Phong getDuLieuPhong(int idPhong) {
        String nhan;
        try {
            os.writeObject(GET_DL);
            os.writeObject(idPhong);
            nhan = (String) is.readObject();
            System.out.println(nhan);
            Phong phong = (Phong) is.readObject();
            return phong;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void vaoPhong(int idP) {
        String nhan;
        try {
            os.writeObject(VAO_P);
            os.writeObject(idP);
            os.writeObject(nguoiDung);
            nhan = (String) is.readObject();
            System.out.println(nhan);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkThayDoiPhong() {
        String nhan;
        try {
            os.writeObject(THAY_DOI);

        } catch (IOException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public void guiDuLieuDenClient() {
        String nhan;
    }

    public void xoaBanBe(int idNguoiDung, int idBB) {
        try {
            os.writeObject("XOABAN");
            os.writeObject(idNguoiDung);
            os.writeObject(idBB);
            System.out.println((String) is.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Phong moiBanBeChoiGame(int idBB, int idP) {
        try {
            os.writeObject("MOIBANBE");
            os.writeObject(idBB);
            os.writeObject(idP);
            os.writeObject(nguoiDung);
            Phong traVe = (Phong) is.readObject();
            if (traVe != null) {
                return traVe;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public boolean themBanBe(int idBanMuonThem) {
        try {
            os.writeObject("MOI_THEM_BAN");
            os.writeObject(idBanMuonThem);
            os.writeObject(nguoiDung);
            int kq = (int) is.readObject();
            if (kq == 1) {
                return true;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
