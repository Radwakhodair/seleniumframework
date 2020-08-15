package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addproductreview extends PageBase {

	public addproductreview(WebDriver driver) {
		super(driver);
		
	}
@FindBy(id="AddProductReview_Title")
WebElement ReviewtitleTxt;

@FindBy(id="AddProductReview_ReviewText")
WebElement ReviewtextTxt;

@FindBy(id="addproductrating_4")
WebElement Rating4RdBtn;

@FindBy(name="add-review")
 WebElement submitReviewBtn;

@FindBy(css="div.result")
public WebElement ReviewNotification;




public void writereview(String reviewtitle,String reviewtxt)
{
	SetTextElementText(ReviewtitleTxt, reviewtitle);
	SetTextElementText(ReviewtextTxt,reviewtxt);
	clickbutton(Rating4RdBtn);
	clickbutton(submitReviewBtn);
}

}
