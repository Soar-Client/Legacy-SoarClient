package me.eldodebug.soar.management.mods;

import me.eldodebug.soar.Soar;
import me.eldodebug.soar.management.language.TranslateText;
import me.eldodebug.soar.management.nanovg.NanoVGManager;
import me.eldodebug.soar.management.nanovg.font.Fonts;

public class SimpleHUDMod extends HUDMod {

	public SimpleHUDMod(TranslateText nameTranslate, TranslateText descriptionText) {
		super(nameTranslate, descriptionText);
	}

	public void draw() {
		
		Soar instance = Soar.getInstance();
		NanoVGManager nvg = instance.getNanoVGManager();
		boolean hasIcon = getIcon() != null;
		float addX = hasIcon ? this.getTextWidth(getIcon(), 9.5F, Fonts.ICON) + 4 : 0;
		
		if(getText() != null) {
			nvg.setupAndDraw(() -> {
				
				float bgWidth = (this.getTextWidth(this.getText(), 9, Fonts.REGULAR) + 10) + addX;
				
				this.drawBackground(bgWidth, 18);
				this.drawText(this.getText(), 5.5F + addX, 5.5F, 9, Fonts.REGULAR);
				
				if(hasIcon) {
					this.drawText(getIcon(), 5.5F, 4F, 10.4F, Fonts.ICON);
				}
				
				this.setWidth((int) bgWidth);
				this.setHeight(18);
			});
		}
	}
	
	public String getText() {
		return null;
	}
	
	public String getIcon() {
		return null;
	}
}