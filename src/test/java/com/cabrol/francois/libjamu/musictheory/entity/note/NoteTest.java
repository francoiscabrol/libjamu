package com.cabrol.francois.libjamu.musictheory.entity.note;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Francois Cabrol <francois.cabrol@live.fr>
 * @since 2014-06-16
 */
public class NoteTest {

    @Test
    public void createANote() {
        Note note = new Note (new RhythmicNote(0, 1), new Key (50));
        Assert.assertEquals(note.getKey().getMidiKey() == 50, true);
    }

}
