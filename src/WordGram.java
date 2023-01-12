import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @Clara Savchik
 *
 */
public class WordGram {

	private String[] myWords;
	private String myToString; // cached string
	private int myHash;        // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 *
	 * @param source is array of strings from which copying occurs
	 * @param start  starting index in source for strings to be copied
	 * @param size   the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		for (int k = start; k < start + size; k++) {
			myWords[k - start] = source[k];

			// TODO: initialize all instance variable
		}
	}

		/**
		 * Return string at specific index in this WordGram
		 * @param index in range [0..length() ) for string
		 * @return string at index
		 */
		public String wordAt(int index){
			if (index < 0 || index >= myWords.length) {
				throw new IndexOutOfBoundsException("bad index in wordAt " + index);
			}
			return myWords[index];
		}

		/**
		 * uses array method .length on array myWords to find the number of elements
		 * @return the length of the array myWords
		 */
		public int length () {
			// TODO: change this
			return myWords.length;
		}


		/**
		 * Checks to see if 1) object o is of the class WordGram and 2) object o is equal to this object myWords
		 * @param o is the object in question
		 * @return boolean (true or false) whether or not object o is equal, meaning it has the same strings in the same order to this object myWords
		 */
		@Override
		public boolean equals (Object o){
			if (!(o instanceof WordGram) || o == null) {
				return false;
			}
			WordGram wg = (WordGram) o;
			if (!Arrays.equals(wg.myWords, myWords)) {
				return false;
			}
			// TODO: Complete this method


			return true;
		}

	/**
	 * finds the designated hashcode of the string version of this WordGram using .toString() and .hashCode()
	 * @return int value myHash that represents the designated hashCode of the string version of this object
	 */
		@Override
		public int hashCode () {
			// TODO: complete this method
			if (myHash == 0) {
				myHash = this.toString().hashCode();
			}


			return myHash;
		}


		/**
		 * Creates a shifted WordGram of this object
		 * @param last is last String of returned WordGram
		 * @return a new WordGram wg that is a shifted version of myWords; each element in myWords is shifted over to one smaller index, removing the first element and adding new element last to the end
		 */
		public WordGram shiftAdd (String last){
			WordGram wg = new WordGram(myWords, 0, myWords.length);
			for (int k = 0; k < (myWords.length-1); k++) {
				wg.myWords[k] = myWords[k + 1];
			}
			wg.myWords[((wg.myWords.length) - 1)] = last;

			return wg;
		}

	/**
	 * converts the array myWords to a string object using the method String.join()
	 * @return string version, myToString, of the array myWords
	 */
	@Override
		public String toString () {
			if (myToString == null) {
				myToString = String.join(" ", myWords);
		}
			return myToString;
		}
	}



