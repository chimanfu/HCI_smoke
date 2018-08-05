package tools

import com.kms.katalon.core.annotation.Keyword
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum


public class TestDataGenerator {
	public static Lorem lorem = LoremIpsum.getInstance();

	@Keyword
	public String getRandomWords(int a, int b) {
		String ranPar = lorem.getWords(a, b);
		return ranPar;
	}
	@Keyword
	public String getRandomParagraphs(int a, int b) {
		String ranPar = lorem.getParagraphs(a, b);
		return ranPar;
	}
	@Keyword
	public String getRandomName(int a, int b) {
		String ranPar = lorem.getName().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomFemaleName() {

		String ranPar = lorem.getNameFemale().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomMaleName() {

		String ranPar = lorem.getNameMale().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomFirstName() {

		String ranPar = lorem.getFirstName().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public static String getRandomLastName() {

		String ranPar = lorem.getLastName().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomCity() {

		String ranPar = lorem.getCity().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomStateFull() {

		String ranPar = lorem.getStateFull().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomStateAbbr() {

		String ranPar = lorem.getStateAbbr().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomCountry() {

		String ranPar = lorem.getCountry().replaceAll("[^a-zA-Z]+", "");
		return ranPar;
	}
	@Keyword
	public  String getRandomZipCode() {

		String ranPar = lorem.getZipCode();
		return ranPar;
	}
	@Keyword
	public  String getRandomPhone() {

		String ranPar = lorem.getPhone();
		return ranPar;
	}
	@Keyword
	public  String getRandomHeading(int numberofWords) {

		String ranPar = lorem.getTitle(numberofWords);
		return ranPar;
	}
	@Keyword
	public  String getRandomHeading_two(int Wordsfrom, int wordstwo) {

		String ranPar = lorem.getTitle(Wordsfrom, wordstwo);
		return ranPar;
	}
	@Keyword
	public  String getRandomEmail() {

		String ranPar = lorem.getEmail();
		return ranPar;
	}
	@Keyword
	public final static String set_RandomNumber(long len) {
		if (len > 18)
			throw new IllegalStateException("To many digits");
		long tLen = (long) Math.pow(10, len - 1) * 9;

		long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

		String tVal = number + "";
		if (tVal.length() != len) {
			throw new IllegalStateException("The random number '" + tVal + "' is not '" + len + "' digits");
		}
		return tVal;
	}
	private static String uuidString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	@Keyword
	public static String set_RandomNumberWithText(int length){
		StringBuffer buffer = new StringBuffer();
		while (buffer.length() < length) {
			buffer.append(uuidString());
		}

		return buffer.substring(0, length);
	}
}
