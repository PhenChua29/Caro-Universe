package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Frame.*;

public class CreditPanel extends JPanel implements ActionListener {

    private JButton ReturnButton;

    public CreditPanel() {
        init();
        init_button();
        init_background();
    }

    private void init() {
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setBounds(0, 0, 800, 800);
    }

    private void init_button() {
        ReturnButton = new JButton();
        ReturnButton.setForeground(Color.BLACK);
        ReturnButton.addActionListener(this);
        ReturnButton.setBounds(30, 22, 60, 40);
        ReturnButton.setFocusable(false);
        ReturnButton.setFont(new Font("Ink Free", Font.BOLD, 75));

        ReturnButton.setBackground(Color.red);
        ReturnButton.setOpaque(false);
        ReturnButton.setFocusable(false);
        ReturnButton.setFocusPainted(false);
        ReturnButton.setBorderPainted(false);
        ReturnButton.setContentAreaFilled(false);

        this.add(ReturnButton, BorderLayout.NORTH);
    }

    private void init_background() {
        JLabel imgBg = new JLabel();
        imgBg.setIcon(new ImageIcon(getClass().getResource("/img/3.png")));
        imgBg.setBounds(0, 0, 800, 800);
        this.add(imgBg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setMenu_trigger(true);
    }
}

// Hover effect
//    public void ButtonEffect(JButton button, JLabel label) {
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            //70, 150, 90
//            public void mouseEntered(MouseEvent e) {
//                button.setBorder(new CompoundBorder(
//                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
//                        BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
//            }
//            
//            @Override
//            public void mouseExited(MouseEvent e) {
//                button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 1, Color.BLACK));
//            }
//            
////            @Override
////            public void mousePressed(MouseEvent e) {
////                button.setIcon(new ImageIcon(allImg[5].getScaledInstance(button.getWidth() + 100, button.getHeight() + 80, Image.SCALE_SMOOTH)));
////                button.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
////                label.setForeground(new Color(200, 60, 60));
////                try {
////                    label.setFont(GetFuronsFont(label.getFont().getSize() + 10));
////                } catch (FontFormatException ex) {
////                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (IOException ex) {
////                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
////            
////            @Override
////            public void mouseReleased(MouseEvent e) {
////                button.setIcon(new ImageIcon(allImg[4].getScaledInstance(button.getWidth() + 100, button.getHeight() + 30, Image.SCALE_SMOOTH)));
////                button.setBorder(new CompoundBorder(
////                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
////                        BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
////                label.setForeground(new Color(160, 200, 210));
////                try {
////                    label.setFont(GetFuronsFont(label.getFont().getSize() - 10));
////                } catch (FontFormatException ex) {
////                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (IOException ex) {
////                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                
////            }
////        });
//    }
////}
//  Move component 
//    public void ButtonEffect(JButton button, JLabel label) {
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            //70, 150, 90
//            public void mouseEntered(MouseEvent e) {
//                button.setBorder(new CompoundBorder(
//                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
//                        BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
//            }
//            
//            @Override
//            public void mouseExited(MouseEvent e) {
//                button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 1, Color.BLACK));
//            }
//            
//            @Override
//            public void mousePressed(MouseEvent e) {
//                button.setIcon(new ImageIcon(allImg[5].getScaledInstance(button.getWidth() + 100, button.getHeight() + 80, Image.SCALE_SMOOTH)));
//                button.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
//                label.setForeground(new Color(200, 60, 60));
//                try {
//                    label.setFont(GetFuronsFont(label.getFont().getSize() + 10));
//                } catch (FontFormatException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                button.setIcon(new ImageIcon(allImg[4].getScaledInstance(button.getWidth() + 100, button.getHeight() + 30, Image.SCALE_SMOOTH)));
//                button.setBorder(new CompoundBorder(
//                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
//                        BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
//                label.setForeground(new Color(160, 200, 210));
//                try {
//                    label.setFont(GetFuronsFont(label.getFont().getSize() - 10));
//                } catch (FontFormatException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            }
//        });
//    }
//    
