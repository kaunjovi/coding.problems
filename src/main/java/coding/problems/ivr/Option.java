package coding.problems.ivr;

public class Option {

	private final String breadCrumb;
	private final String welcomeMessage;

	Option(String breadCrumb, String welcomeMessage) {
		this.breadCrumb = breadCrumb;
		this.welcomeMessage = welcomeMessage;
	}

	public String getBreadCrumb() {
		return breadCrumb;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}
}
