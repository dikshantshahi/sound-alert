package com.dikshant.adhoc.sound.util.start;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 ******************************************************************************
 * Platform: OS
 * Program Name: SoundAlert.java
 * Author: DikshantS
 * Date Created: Jul 20, 2016
 * Copyright: Copyright (c) 2016 Dikshant Shahi. All Rights Reserved.
 * Desc: A simple Java class to alert with beep sound.
 *       Ideal for scenario when you want to be informed when you are around
 *      your machine but nor actively using it.
 ******************************************************************************
 * Mod Log
 * ---------
 * Date : Modified By : Description
 *
 ******************************************************************************
 */
public class SoundAlert {

    private static final String BEEP_FILE = "beep.wav";

    private AudioInputStream audioIn = null;

    /**
     * Initialize: Load the file
     */
    public void init() throws IOException {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(classLoader.getResource(BEEP_FILE).getFile())));
        } catch (UnsupportedAudioFileException | IOException ioe) {
            throw new IOException(ioe.getLocalizedMessage());
        }
    }

    /**
     * Base method to alert with a sound so that to grab attention and take appropriate action
     * 
     * TODO: Modify the method to spawn a new Thread which alerts to avoid slowness in the ongoing processing
     */
    public void alert() {

        try {
            if (null == audioIn) {
                init();
            }

            if (null != audioIn) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();

                Thread.sleep(100);
            }

        } catch (IOException | LineUnavailableException | InterruptedException ex) {
            // no-msg
        }
    }

    /**
     * Close gracefully
     */
    public void close() {
        try {
            if (null != audioIn) {
                audioIn.close();
            }
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        SoundAlert sound = new SoundAlert();
        sound.alert();
        sound.close();
    }
}
