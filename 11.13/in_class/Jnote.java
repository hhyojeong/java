package in_class;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Jnote extends JFrame {
    private JTextPane _textPane;
    private ActionMap _actionMap;
    private boolean _isSaved = true;
    private JFileChooser _fc = new JFileChooser(".");
    private File _file = null;

    public Jnote()
    {
        super("                              ");
        _textPane=new JTextPane();
        _textPane.getDocument().addDocumentListener (new DocumentListener()
        {
            public void insertUpdate (DocumentEvent e)
            {
                _isSaved = false;
            }

            public void removeUpdate (DocumentEvent e)
            {
                _isSaved = false;
            }
            public void changedUpdate(DocumentEvent e)
            {
                _isSaved = false;
            }
        });
        JScrollPane p = new JScrollPane(_textPane);
        add(p);
        _actionMap = createActionMap();
        setJMenuBar(createMenuBar());
        add(createToolBar(), BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




    private JMenuBar createMenuBar() {
        JMenuBar menubar = new JMenuBar();
        //File
        JMenu m = new JMenu("파일");
        m.add(new JMenuItem(_actionMap.get("새파일")));
        m.add(new JMenuItem(_actionMap.get("열기")));
        m.add(new JMenuItem(_actionMap.get("저장")));
        m.add(new JMenuItem(_actionMap.get("다른이름으로 저장")));
        m.addSeparator();
        m.add(new JMenuItem(_actionMap.get("종료")));
        menubar.add(m);

        //Edit
        m = new JMenu("수정");
        m.add(new JMenuItem(_actionMap.get("잘라내기")));
        m.add(new JMenuItem(_actionMap.get("복사")));
        m.add(new JMenuItem(_actionMap.get("붙여넣기")));
        m.addSeparator(); // 추가된 구분선
        m.add(new JMenuItem(_actionMap.get("찾기"))); // 찾기 추가
        m.add(new JMenuItem(_actionMap.get("바꾸기"))); // 바꾸기 추가
        menubar.add(m);

        //Help
        m = new JMenu("도움말");
        m.add(new JMenuItem(_actionMap.get("도움말")));
        m.add(new JMenuItem(_actionMap.get("정보")));
        menubar.add(m);

        return menubar;
    }

    private JToolBar createToolBar() {
        JToolBar toolbar = new JToolBar();
        toolbar.add(new JButton(_actionMap.get("새파일")));
        toolbar.add(new JButton(_actionMap.get("열기")));
        toolbar.add(new JButton(_actionMap.get("저장")));
        toolbar.add(new JButton(_actionMap.get("다른이름으로 저장")));
        toolbar.addSeparator();

        toolbar.add(new JButton(_actionMap.get("복사")));
        toolbar.add(new JButton(_actionMap.get("잘라내기")));
        toolbar.add(new JButton(_actionMap.get("붙여넣기")));
        toolbar.addSeparator();

        toolbar.add(new JButton(_actionMap.get("찾기"))); // 찾기 추가
        toolbar.add(new JButton(_actionMap.get("바꾸기"))); // 바꾸기 추가
        toolbar.addSeparator();

        toolbar.add(new JButton(_actionMap.get("도움말")));
        toolbar.add(new JButton(_actionMap.get("정보")));

        Component[] comps = toolbar.getComponents();
        for (Component c : comps)
        {
            if(c instanceof JButton)
                c.setFocusable(false);
        }

        return toolbar;
    }

    // --- 파일 관련 액션 ---

    private class NewAction extends AbstractAction
    {
        public NewAction()
        {
            super("새파일");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+N"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            if(!confirmSave()) return; // 저장 확인 추가
            _textPane.setText("");
            _file = null; // 새 파일이므로 현재 파일 정보 제거
            setTitle(" - JNotePad");
            _isSaved = true;
        }
    }

    private class OpenAction extends AbstractAction
    {
        public OpenAction(){
            super("열기");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+O"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
        }

        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            if(!confirmSave())
                return;
            _isSaved = open();
        }
    }

    private boolean open()
    {
        if(_fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            File file = _fc.getSelectedFile();
            try {
                open(file);
                _file = file;
                setTitle(file.getName() + " - JNotePad");
                return true;
            } catch (IOException e){
                JOptionPane.showMessageDialog(
                        this,
                        "파일을 열 수 없습니다: " + file,
                        "텍스트 에디터",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false; // 파일 선택 취소 시
    }


    private boolean confirmSave() {
        if(_isSaved)
            return true;
        int ret = JOptionPane.showConfirmDialog
                (
                        this,
                        "내용이 수정되었습니다. 저장하겠습니까?",
                        "텍스트 에디터",
                        JOptionPane.YES_NO_CANCEL_OPTION);
        switch(ret){
            case JOptionPane.YES_OPTION:
                // save()가 성공해야 true 반환
                return save();
            case JOptionPane.NO_OPTION:
                return true;
            default:
                return false;
        }
    }

    private boolean save()
    {
        if(_file==null)
            return saveAs();
        else
            try {
                save(_file);
                _isSaved = true; // 저장 성공
                return true;
            } catch (IOException e) {
                showSaveErrorMessage(e);
            }
        return false;
    }


    private void showSaveErrorMessage(IOException e) {
        e.printStackTrace();
        String mesg = "저장 할 수 없습니다: " + (_file != null ? _file.getName() : "새 파일") + "\n접근불가";
        JOptionPane.showMessageDialog(
                this,
                mesg,
                "텍스트 에디터",
                JOptionPane.ERROR_MESSAGE);
    }

    private void save(File file) throws IOException
    {
        BufferedWriter w = new BufferedWriter(new FileWriter(file));
        w.write(_textPane.getText());
        w.close();
        setTitle(file.getName() + " - JNotePad"); // 제목 업데이트
    }

    public boolean saveAs()
    {
        if (_fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File file = _fc.getSelectedFile();
            try
            {
                save(file);
                _file = file;
                setTitle(file.getName() + " - JNotePad");
                _isSaved = true;
                return true;
            }catch (IOException e){
                showSaveErrorMessage(e);
                return false;
            }
        }
        return false;
    }

    private class SaveAction extends AbstractAction
    {
        public SaveAction() {
            super("저장");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+S"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            _isSaved = save();
        }
    }

    private class SaveAsAction extends AbstractAction
    {
        public SaveAsAction()
        {
            super("다른이름으로 저장");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+A"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            _isSaved = saveAs(); // saveAs() 결과를 _isSaved에 저장
        }
    }

    private void open(File file) throws IOException
    {
        BufferedReader r = new BufferedReader (new FileReader(file));
        StringBuilder sbuf = new StringBuilder(); // StringBuffer 대신 StringBuilder 사용
        char[] buf = new char[1024];
        int nread;

        while ((nread = r.read(buf)) != -1){
            sbuf.append(buf, 0, nread);
        }
        r.close();
        _textPane.setText(sbuf.toString());
    }

    private class ExitAction extends AbstractAction
    {
        public ExitAction()
        {
            super("종료");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+E"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            if(!confirmSave())
                return;
            System.exit(0);
        }
    }

    // --- 편집 관련 액션 ---

    private class CutAction extends AbstractAction
    {
        public CutAction()
        {
            super("잘라내기");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+X"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            _textPane.cut();
        }
    }

    private class CopyAction extends AbstractAction
    {
        public CopyAction()
        {
            super("복사"); // 복사하기 -> 복사
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+C"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            _textPane.copy();
        }
    }

    private class PasteAction extends AbstractAction
    {
        public PasteAction()
        {
            super("붙여넣기");
            // 붙여넣기는 보통 Ctrl+V
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+V"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            _textPane.paste();
        }
    }

    // --- 찾기/바꾸기 관련 기능 ---

    private class FindAction extends AbstractAction
    {
        public FindAction()
        {
            super("찾기");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+F"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_F);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            new FindDialog(Jnote.this, "찾기", false).setVisible(true);
        }
    }

    private class ReplaceAction extends AbstractAction
    {
        public ReplaceAction()
        {
            super("바꾸기");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+R"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        }
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(getValue(Action.NAME));
            new FindDialog(Jnote.this, "바꾸기", true).setVisible(true);
        }
    }

    private boolean find(String searchText, boolean forward) {
        if (searchText == null || searchText.isEmpty()) return false;

        Highlighter highlighter = _textPane.getHighlighter();
        highlighter.removeAllHighlights(); // 기존 하이라이트 제거

        String content = _textPane.getText();
        int currentPos = _textPane.getCaretPosition();
        int index;

        if (forward) {
            // 정방향 검색
            index = content.indexOf(searchText, currentPos);
        } else {
            // 역방향 검색 (단순 구현을 위해 텍스트 시작부터 검색)
            index = content.lastIndexOf(searchText, currentPos > 0 ? currentPos - 1 : content.length());
        }

        if (index != -1) {
            try {
                // 찾은 텍스트 하이라이트
                highlighter.addHighlight(index, index + searchText.length(),
                        new DefaultHighlighter.DefaultHighlightPainter(java.awt.Color.YELLOW));
                // 캐럿 위치 이동
                _textPane.setCaretPosition(index + searchText.length());
                return true;
            } catch (BadLocationException ble) {
                ble.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(this, "'" + searchText + "'를 찾을 수 없습니다.", "찾기", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }

    private void replace(String findText, String replaceText) {
        if (findText == null || findText.isEmpty()) return;

        Highlighter highlighter = _textPane.getHighlighter();
        highlighter.removeAllHighlights();

        String content = _textPane.getText();
        int currentPos = _textPane.getSelectionStart();

        // 현재 선택된 텍스트가 찾을 텍스트와 일치하는지 확인
        if (currentPos != -1 && _textPane.getSelectedText() != null && _textPane.getSelectedText().equals(findText)) {
            // 선택된 텍스트를 대체
            _textPane.replaceSelection(replaceText);
            _isSaved = false;
        } else {
            // 현재 선택이 없거나 일치하지 않으면, 현재 위치부터 다음 텍스트를 찾아 대체
            int index = content.indexOf(findText, _textPane.getCaretPosition());
            if (index != -1) {
                try {
                    _textPane.getDocument().remove(index, findText.length());
                    _textPane.getDocument().insertString(index, replaceText, null);
                    _isSaved = false;
                } catch (BadLocationException ble) {
                    ble.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "'" + findText + "'를 찾을 수 없습니다.", "바꾸기", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void replaceAll(String findText, String replaceText) {
        if (findText == null || findText.isEmpty()) return;

        String content = _textPane.getText();
        if(content.contains(findText)) {
            content = content.replaceAll(findText, replaceText);
            _textPane.setText(content);
            _isSaved = false;
        } else {
            JOptionPane.showMessageDialog(this, "'" + findText + "'를 찾을 수 없습니다.", "모두 바꾸기", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // --- 찾기/바꾸기 대화상자 클래스 ---

    private class FindDialog extends JDialog implements ActionListener {
        private JTextField findField, replaceField;
        private JButton findNextButton, replaceButton, replaceAllButton, cancelButton;
        private JCheckBox matchCase;
        private JRadioButton upButton, downButton;
        private boolean isReplace;
        private Jnote owner;

        public FindDialog(Jnote owner, String title, boolean isReplace) {
            super(owner, title, false); // Modal: false
            this.owner = owner;
            this.isReplace = isReplace;

            setLayout(new BorderLayout(5, 5));
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            // 텍스트 필드와 라벨
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

            findField = new JTextField(15);
            JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            findPanel.add(new JLabel("찾을 내용:"));
            findPanel.add(findField);
            textPanel.add(findPanel);

            if (isReplace) {
                replaceField = new JTextField(15);
                JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                replacePanel.add(new JLabel("바꿀 내용:"));
                replacePanel.add(replaceField);
                textPanel.add(replacePanel);
            }
            add(textPanel, BorderLayout.CENTER);

            // 옵션 및 방향
            JPanel optionPanel = new JPanel(new BorderLayout());
            matchCase = new JCheckBox("대소문자 구분");
            optionPanel.add(matchCase, BorderLayout.WEST);

            JPanel directionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            directionPanel.add(new JLabel("방향:"));
            upButton = new JRadioButton("위로");
            downButton = new JRadioButton("아래로", true); // 기본값 아래로
            ButtonGroup group = new ButtonGroup();
            group.add(upButton);
            group.add(downButton);
            directionPanel.add(upButton);
            directionPanel.add(downButton);
            optionPanel.add(directionPanel, BorderLayout.EAST);

            add(optionPanel, isReplace ? BorderLayout.NORTH : BorderLayout.SOUTH);

            // 버튼
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            findNextButton = new JButton("다음 찾기");
            findNextButton.addActionListener(this);
            buttonPanel.add(findNextButton);

            if (isReplace) {
                replaceButton = new JButton("바꾸기");
                replaceButton.addActionListener(this);
                buttonPanel.add(replaceButton);

                replaceAllButton = new JButton("모두 바꾸기");
                replaceAllButton.addActionListener(this);
                buttonPanel.add(replaceAllButton);
            }

            cancelButton = new JButton("취소");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            add(buttonPanel, BorderLayout.EAST); // 버튼을 오른쪽에 배치

            // 기본 설정
            pack();
            setLocationRelativeTo(owner);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            String findText = findField.getText();

            if (source == findNextButton) {
                owner.find(findText, downButton.isSelected());
            } else if (source == replaceButton) {
                String replaceText = replaceField.getText();
                owner.replace(findText, replaceText);
            } else if (source == replaceAllButton) {
                String replaceText = replaceField.getText();
                owner.replaceAll(findText, replaceText);
            } else if (source == cancelButton) {
                // 하이라이트 제거 후 창 닫기
                owner._textPane.getHighlighter().removeAllHighlights();
                dispose();
            }
        }
    }


    // --- 도움말 관련 액션 ---

    private class AboutAction extends AbstractAction
    {
        public AboutAction()
        {
            super("정보");
        }
        public void actionPerformed(ActionEvent e)
        {
            String[] mesg={
                    "텍스트 에디터 v1",
                    "제작자: 최경섭",
                    "기능: 파일 입출력, 기본 편집, 찾기/바꾸기"
            };
            JOptionPane.showMessageDialog(Jnote.this, mesg, "텍스트 에디터 정보", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class HelpAction extends AbstractAction
    {
        public HelpAction()
        {
            super("도움말");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl+H"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_H);
        }
        public void actionPerformed(ActionEvent e)
        {
            String[] mesg = {
                    "간단한 텍스트 에디터입니다.",
                    "파일 메뉴: 새파일, 열기, 저장, 다른 이름으로 저장, 종료",
                    "수정 메뉴: 잘라내기, 복사, 붙여넣기, 찾기, 바꾸기"
            };
            JOptionPane.showMessageDialog(Jnote.this, mesg, "텍스트 에디터", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private ActionMap createActionMap()
    {
        ActionMap am = new ActionMap();
        am.put("정보", new AboutAction());
        am.put("도움말", new HelpAction());
        am.put("잘라내기", new CutAction());
        am.put("복사", new CopyAction());
        am.put("붙여넣기", new PasteAction());
        am.put("종료", new ExitAction());
        am.put("새파일", new NewAction());
        am.put("열기", new OpenAction());
        am.put("저장", new SaveAction());
        am.put("다른이름으로 저장", new SaveAsAction());
        am.put("찾기", new FindAction()); // 찾기 추가
        am.put("바꾸기", new ReplaceAction()); // 바꾸기 추가
        return am;
    }

    private void start() {
        setSize(600,480);
        setLocation(100, 100);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Jnote().start();
    }
}