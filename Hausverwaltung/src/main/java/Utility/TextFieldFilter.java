/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Phineas Gaming
 */
public class TextFieldFilter extends PlainDocument {
  public static final String NUMERIC = "0123456789";
  public static final String DECIMAL = ".";
  public static final String DATE = "0123456789.-";

  protected String acceptedChars = null;

  protected boolean negativeAccepted = false;

  public TextFieldFilter() {
    this(NUMERIC);
  }

  public TextFieldFilter(String acceptedchars) {
    acceptedChars = acceptedchars;
  }

  public void setNegativeAccepted(boolean negativeaccepted) {
    if (acceptedChars.equals(NUMERIC)) {
      negativeAccepted = negativeaccepted;
      acceptedChars += "-";
    }
  }

  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    for (int i = 0; i < str.length(); i++) {
      if (acceptedChars.indexOf(str.valueOf(str.charAt(i))) == -1)
        return;
    }

    if (negativeAccepted && str.indexOf("-") != -1) {
      if (str.indexOf("-") != 0 || offset != 0) {
        return;
      }
    }

    super.insertString(offset, str, attr);
  }
}
