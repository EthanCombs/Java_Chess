public class NumLetterConverter{
  /** Returns the number representing the position of letter in the
   *  alphabet, where A is at position 0, Z  is at position 25
   *  Precondition: letter is a String containing one uppercase
   *  letter character only.
   */
  public static int letterToNum(String letter)
  {
    char l = '?';
    if(letter.length()==1) l = letter.charAt(0);
    if(!Character.isUpperCase(l)) return -1;
    return (int) l - 65;
  }

  /** Returns a String consisting of the single upper case letter which
   *  is at the position num in the alphabet, where A is at position 0,
   *  Z is at position 25
   *  Precondition: num is between 0 and 25 inclusive
   */
  public static String numToLetter(int num)
  {
    if(num < 0 || num > 26) return "?";
    return Character.toString((char)(num + 65));
  }
  public static int tryLetterToNum(String letter)
  {
    try {return letterToNum(letter);}
    catch (NumberFormatException e){return -1;}
  }
}