package report;

/*
    "파일", "편집", "보기", "입력" 등의 4가지 메뉴를 가진 스윙 프로그램을 작성하라.
    "보기", 메뉴에만 "화면확대","쪽윤곽"의 2개의 메뉴아이템이 있다.
*/

import javax.swing.*;

public class MenuItem extends JFrame {

    public MenuItem(){
        setTitle("메뉴 만들기");
        createMenu();
        setSize(250, 200);
        setVisible(true);
    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu screenMenu = new JMenu("보기");
        screenMenu.add(new JMenuItem("화면확대"));
        screenMenu.add(new JMenuItem("쪽윤곽"));


        mb.add(new JMenu("파일"));
        mb.add(new JMenu("편집"));
        mb.add(screenMenu);
        mb.add(new JMenu("입력"));

        setJMenuBar(mb);

    }

    public static void main(String[] args){
        new MenuItem();
    }
}
