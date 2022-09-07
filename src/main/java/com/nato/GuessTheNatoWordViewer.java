package com.nato;

import com.nato.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public class GuessTheNatoWordViewer extends JFrame {
    private final CardLayout cards;
    private final IntroPanel introPanel;
    private final GuessWordPanel guessWordPanel;
    private final WinPanel winPanel;
    private final LosePanel losePanel;
    private String currentPanel;

    public GuessTheNatoWordViewer() {
        /* layout */
        this.cards = new CardLayout();

        /* panels */
        this.introPanel = new IntroPanel();
        this.guessWordPanel = new GuessWordPanel(this);
        this.winPanel = new WinPanel(this);
        this.losePanel = new LosePanel(this);
        this.currentPanel = "";

        /* set the main frame */
        setFrame();
    }


    /* set panels */


    public void setIntro(String INTRO_MESSAGE) {
        introPanel.set(INTRO_MESSAGE);
        add(introPanel, "intro panel");
    }

    public void setGuessWordPanel() {
        guessWordPanel.set();
        add(guessWordPanel, "guess word panel");
    }

    public void setWinPanel(int points) {
        winPanel.set(points);
        add(winPanel, "win panel");
    }


    public void setLosePanel() {
        losePanel.set();
        add(losePanel, "lose panel");
    }


    /* show panels */


    public void showIntro() {
        currentPanel = "intro panel";
        cards.show(this.getContentPane(), "intro panel");
    }

    public void showGuessWordPanel() {
        currentPanel = "guess word panel";
        cards.show(this.getContentPane(), "guess word panel");
    }

    public void showLosePanel() {
        currentPanel = "lose panel";
        cards.show(this.getContentPane(), "lose panel");
    }

    public void showWinPanel() {
        cards.show(this.getContentPane(), "win panel");
    }

    public void showTimeOverPanel() {
        cards.show(this.getContentPane(), "time over panel");
    }


    /* guess word viewer utilities */


    public String getCurrentPanel() {
        return currentPanel;
    }
    public String getGuessInput() {
        return guessWordPanel.getGuessWord();
    }

    public void clearGuessInput() {
        guessWordPanel.clearWordInput();
    }

    public void showTip(char correctChar) {
        guessWordPanel.showTip(correctChar);
    }

    public void showCorrectWordMessage() {
        guessWordPanel.showCorrectWordMessage();
    }

    public void showWrongWordMessage(String correctWord) {
        guessWordPanel.showWrongWordMessage(correctWord);
    }

    public void updatePoints(int points) {
        guessWordPanel.updatePoints(points);
    }


    /* listeners */


    public void addIntroEnterListener(KeyListener listener) {
        addKeyListener(listener);
    }

    public void removeIntroEnterListener(KeyListener listener) {
        removeKeyListener(listener);
    }
    public void addWordInputListener(FocusListener listener) {
        guessWordPanel.addWordInputFocusedListener(listener);
    }

    public void addGuessButtonClickListener(ActionListener listener) {
        guessWordPanel.addGuessButtonClickListener(listener);
    }

    public void addEnterPressedListener(KeyListener listener) {
        guessWordPanel.addEnterPressedListener(listener);
    }


    /* frame settings */
    private void setFrame() {
        setResizable(false);
        setType(Type.UTILITY);
        setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(this.getState() | JFrame.MAXIMIZED_BOTH); // maximize the window screen
//        setSize(1024, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
