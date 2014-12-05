package controladores;

import javax.speech.*;
import javax.speech.synthesis.*;
import javax.speech.recognition.*;
import java.util.Locale;

public class Habla
{
    private static void hablar()
    {
        try
		{
                    /*SynthesizerModeDesc smd = new SynthesizerModeDesc(Locale.ENGLISH);
                    if(smd == null)
                    {
                        System.out.println("no smd");
                    }
                    System.out.println(smd.toString());*/
                    
                    SynthesizerModeDesc emd = new SynthesizerModeDesc(Locale.ENGLISH);
                    Synthesizer synth = Central.createSynthesizer(emd);
                    Synthesizer s2 =  Central.createSynthesizer(emd);
                    if(emd == null)
                    {
                        System.out.println("no emd");
                    }
                    System.out.println("1");
                    if(synth == null)
                    {
                        System.out.println("no hay");
                    }else{}
                    if(s2 == null)
                    {
                        System.out.println("tampoco hay");
                    }
                    synth.allocate();
                    synth.resume();
                    synth.speakPlainText("Hello, world!", null);
                    synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synth.deallocate();
		}catch(Exception e)
		{
			System.out.println("No funciono");
			e.printStackTrace();
		}
    }
    
    /*private static void escuchar()
    {
        try
        {
            EngineModeDesc emd = new EngineModeDesc(Locale.ENGLISH);
            Recognizer rec = Central.createRecognizer(emd);
            if(rec == null)
            {
                System.out.println("NOOOOOOO");
            }
        }catch(Exception e)
        {
            System.out.println("no recognizer noooo");
        }
    }*/
	public static void main(String[] args)
	{
            //escuchar();
            hablar();
        }
}