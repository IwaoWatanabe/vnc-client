package ru.dmerkushov.vnc.client.ui;

import ru.dmerkushov.vnc.client.rfb.session.RfbClientSession;
import ru.dmerkushov.vnc.client.rfb.session.password.UiPasswordSupplier;
import ru.dmerkushov.vnc.client.ui.VncView;
import ru.dmerkushov.vnc.client.ui.DefaultSwingVncView;

public class Main1 implements Runnable {
java.io.PrintStream err = System.err;
public void run() {
err.println("VNC Client (Swing) started.");

String host = javax.swing.JOptionPane.showInputDialog("Host", "localhost");
err.println("host: " + host);
int port = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Port", "5901"));
err.println("port: " + port);
javax.swing.JFrame frame = new javax.swing.JFrame("VNC (Swing)");
frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
frame.setSize(800, 600);

try {
    RfbClientSession session = new RfbClientSession(host, port);
    session.setPasswordSupplier(new UiPasswordSupplier());

    VncView vncView = new DefaultSwingVncView();
    vncView.setSession(session);

    frame.add(vncView.getSwingComponent());
    session.startSession();
    frame.setVisible(true);
    vncView.repaint();
} catch (ru.dmerkushov.vnc.client.VncException e) {
    e.printStackTrace();
} catch (java.io.IOException e) {
    e.printStackTrace();
}}

public static void main(String[] args) throws Exception {
    javax.swing.SwingUtilities.invokeLater(new Main1());
}}

