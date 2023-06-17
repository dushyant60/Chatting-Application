package chating.application;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener{
    
    ImageIcon i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;
    JLabel name, status;
    JButton send;
    JTextField t1;
    JPanel p1, a1;
    Box vertical = Box.createVerticalBox();

    Server(){
        setLayout(null);
//Header

//Panel
        p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 60);
        p1.setLayout(null);
        add(p1);

//Images
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,20,20);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });

        i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(35,10,40,40);
        p1.add(profile);

        i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(310,20,25,25);
        p1.add(video);

        i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(350,20,25,25);
        p1.add(phone);

        i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(390,20,25,25);
        p1.add(morevert);

// Profiles
        name = new JLabel("Shadey");
        name.setBounds(90, 15, 200, 25);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        p1.add(name);

        status = new JLabel("Online");
        status.setBounds(90, 35, 150, 25);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 10));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(10, 65, 410, 500);
        add(a1);

        t1 = new JTextField();
        t1.setBounds(11, 580, 300, 35);
        t1.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        add(t1);

        JButton send = new JButton("Send");
        send.setBounds(320, 580, 100, 35);
        send.setBackground(new Color(7,94,84));
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        add(send);




//Frame
        setSize(430, 630);
        setLocation(180, 10);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);



        setVisible(true);
    }

//Action Listner
    public void actionPerformed(ActionEvent ae){
        String out = t1.getText();
        JPanel p2 = formatLabel(out);

        a1.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));

        a1.add(vertical, BorderLayout.PAGE_START);

        t1.setText("");

        repaint();
        invalidate();
        validate();

    }

// Format Label
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 120px\">"+out+"</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,45));
        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);

        return panel;
    }

//Main
    public static void main(String[] args) {
        new Server();
        
    }
}
