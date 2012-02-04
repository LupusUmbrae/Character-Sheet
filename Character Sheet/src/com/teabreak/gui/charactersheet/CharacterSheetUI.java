package com.teabreak.gui.charactersheet;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.teabreak.core.Alignment;
import com.teabreak.gui.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Text;


public class CharacterSheetUI extends ApplicationWindow{
	private Action action;
	private Text txtCharacterName;
	private Text txtCharacterName_1;

	/**
	 * Create the application window.
	 */
	public CharacterSheetUI() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(null);
		
		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setBounds(0, 136, 1068, 488);
		
		TabItem tbtmPage = new TabItem(tabFolder, SWT.NONE);
		tbtmPage.setText("Page 1");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmPage.setControl(composite);
		
		Group grpAbilityScores = new Group(composite, SWT.NONE);
		grpAbilityScores.setText("Ability Scores");
		grpAbilityScores.setBounds(10, 10, 256, 185);
		
		Label lblStrength = new Label(grpAbilityScores, SWT.NONE);
		lblStrength.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblStrength.setBounds(10, 60, 25, 15);
		lblStrength.setText("Str");
		
		Label lblDex = new Label(grpAbilityScores, SWT.NONE);
		lblDex.setText("Dex");
		lblDex.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDex.setBounds(10, 83, 25, 15);
		
		Label lblCon = new Label(grpAbilityScores, SWT.NONE);
		lblCon.setText("Con");
		lblCon.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblCon.setBounds(10, 104, 25, 15);
		
		Label lblInt = new Label(grpAbilityScores, SWT.NONE);
		lblInt.setText("Int");
		lblInt.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblInt.setBounds(10, 125, 25, 15);
		
		Label lblWis = new Label(grpAbilityScores, SWT.NONE);
		lblWis.setText("Wis");
		lblWis.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblWis.setBounds(10, 146, 25, 15);
		
		Label lblCha = new Label(grpAbilityScores, SWT.NONE);
		lblCha.setText("Cha");
		lblCha.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblCha.setBounds(10, 167, 25, 15);
		
		Label lblNewLabel = new Label(grpAbilityScores, SWT.NONE);
		lblNewLabel.setBounds(51, 62, 15, 15);
		lblNewLabel.setText("20");
		
		Label label = new Label(grpAbilityScores, SWT.NONE);
		label.setText("20");
		label.setBounds(51, 104, 15, 15);
		
		Label label_1 = new Label(grpAbilityScores, SWT.NONE);
		label_1.setText("20");
		label_1.setBounds(51, 125, 15, 15);
		
		Label label_2 = new Label(grpAbilityScores, SWT.NONE);
		label_2.setText("20");
		label_2.setBounds(51, 146, 15, 15);
		
		Label label_3 = new Label(grpAbilityScores, SWT.NONE);
		label_3.setText("20");
		label_3.setBounds(51, 167, 15, 15);
		
		Label label_4 = new Label(grpAbilityScores, SWT.NONE);
		label_4.setText("20");
		label_4.setBounds(51, 83, 15, 15);
		
		Label label_5 = new Label(grpAbilityScores, SWT.NONE);
		label_5.setText("=");
		label_5.setBounds(72, 60, 15, 15);
		
		Label label_6 = new Label(grpAbilityScores, SWT.NONE);
		label_6.setText("=");
		label_6.setBounds(72, 83, 15, 15);
		
		Label label_7 = new Label(grpAbilityScores, SWT.NONE);
		label_7.setText("=");
		label_7.setBounds(72, 104, 15, 15);
		
		Label label_8 = new Label(grpAbilityScores, SWT.NONE);
		label_8.setText("=");
		label_8.setBounds(72, 125, 15, 15);
		
		Label label_9 = new Label(grpAbilityScores, SWT.NONE);
		label_9.setText("=");
		label_9.setBounds(72, 146, 15, 15);
		
		Label label_10 = new Label(grpAbilityScores, SWT.NONE);
		label_10.setText("=");
		label_10.setBounds(72, 167, 15, 15);
		
		Label label_11 = new Label(grpAbilityScores, SWT.NONE);
		label_11.setText("20");
		label_11.setBounds(82, 167, 15, 15);
		
		Label label_12 = new Label(grpAbilityScores, SWT.NONE);
		label_12.setText("20");
		label_12.setBounds(82, 146, 15, 15);
		
		Label label_13 = new Label(grpAbilityScores, SWT.NONE);
		label_13.setText("20");
		label_13.setBounds(82, 125, 15, 15);
		
		Label label_14 = new Label(grpAbilityScores, SWT.NONE);
		label_14.setText("20");
		label_14.setBounds(82, 104, 15, 15);
		
		Label label_15 = new Label(grpAbilityScores, SWT.NONE);
		label_15.setText("20");
		label_15.setBounds(82, 83, 15, 15);
		
		Label label_16 = new Label(grpAbilityScores, SWT.NONE);
		label_16.setText("20");
		label_16.setBounds(82, 62, 15, 15);
		
		Label label_23 = new Label(grpAbilityScores, SWT.NONE);
		label_23.setText("+");
		label_23.setBounds(103, 167, 15, 15);
		
		Label label_24 = new Label(grpAbilityScores, SWT.NONE);
		label_24.setText("+");
		label_24.setBounds(103, 146, 15, 15);
		
		Label label_25 = new Label(grpAbilityScores, SWT.NONE);
		label_25.setText("+");
		label_25.setBounds(103, 125, 15, 15);
		
		Label label_26 = new Label(grpAbilityScores, SWT.NONE);
		label_26.setText("+");
		label_26.setBounds(103, 104, 15, 15);
		
		Label label_27 = new Label(grpAbilityScores, SWT.NONE);
		label_27.setText("+");
		label_27.setBounds(103, 83, 15, 15);
		
		Label label_28 = new Label(grpAbilityScores, SWT.NONE);
		label_28.setText("+");
		label_28.setBounds(103, 60, 15, 15);
		
		Label label_29 = new Label(grpAbilityScores, SWT.NONE);
		label_29.setText("20");
		label_29.setBounds(118, 167, 15, 15);
		
		Label label_30 = new Label(grpAbilityScores, SWT.NONE);
		label_30.setText("20");
		label_30.setBounds(118, 146, 15, 15);
		
		Label label_31 = new Label(grpAbilityScores, SWT.NONE);
		label_31.setText("20");
		label_31.setBounds(118, 125, 15, 15);
		
		Label label_32 = new Label(grpAbilityScores, SWT.NONE);
		label_32.setText("20");
		label_32.setBounds(118, 104, 15, 15);
		
		Label label_33 = new Label(grpAbilityScores, SWT.NONE);
		label_33.setText("20");
		label_33.setBounds(118, 83, 15, 15);
		
		Label label_34 = new Label(grpAbilityScores, SWT.NONE);
		label_34.setText("20");
		label_34.setBounds(118, 62, 15, 15);
		
		Label label_35 = new Label(grpAbilityScores, SWT.NONE);
		label_35.setText("20");
		label_35.setBounds(154, 167, 15, 15);
		
		Label label_36 = new Label(grpAbilityScores, SWT.NONE);
		label_36.setText("20");
		label_36.setBounds(154, 146, 15, 15);
		
		Label label_37 = new Label(grpAbilityScores, SWT.NONE);
		label_37.setText("20");
		label_37.setBounds(154, 125, 15, 15);
		
		Label label_38 = new Label(grpAbilityScores, SWT.NONE);
		label_38.setText("20");
		label_38.setBounds(154, 104, 15, 15);
		
		Label label_39 = new Label(grpAbilityScores, SWT.NONE);
		label_39.setText("20");
		label_39.setBounds(154, 83, 15, 15);
		
		Label label_40 = new Label(grpAbilityScores, SWT.NONE);
		label_40.setText("20");
		label_40.setBounds(154, 62, 15, 15);
		
		Label label_41 = new Label(grpAbilityScores, SWT.NONE);
		label_41.setText("+");
		label_41.setBounds(139, 167, 15, 15);
		
		Label label_42 = new Label(grpAbilityScores, SWT.NONE);
		label_42.setText("+");
		label_42.setBounds(139, 146, 15, 15);
		
		Label label_43 = new Label(grpAbilityScores, SWT.NONE);
		label_43.setText("+");
		label_43.setBounds(139, 125, 15, 15);
		
		Label label_44 = new Label(grpAbilityScores, SWT.NONE);
		label_44.setText("+");
		label_44.setBounds(139, 104, 15, 15);
		
		Label label_45 = new Label(grpAbilityScores, SWT.NONE);
		label_45.setText("+");
		label_45.setBounds(139, 83, 15, 15);
		
		Label label_46 = new Label(grpAbilityScores, SWT.NONE);
		label_46.setText("+");
		label_46.setBounds(139, 60, 15, 15);
		
		Label label_47 = new Label(grpAbilityScores, SWT.NONE);
		label_47.setText("20");
		label_47.setBounds(190, 167, 15, 15);
		
		Label label_48 = new Label(grpAbilityScores, SWT.NONE);
		label_48.setText("20");
		label_48.setBounds(190, 146, 15, 15);
		
		Label label_49 = new Label(grpAbilityScores, SWT.NONE);
		label_49.setText("20");
		label_49.setBounds(190, 125, 15, 15);
		
		Label label_50 = new Label(grpAbilityScores, SWT.NONE);
		label_50.setText("20");
		label_50.setBounds(190, 104, 15, 15);
		
		Label label_51 = new Label(grpAbilityScores, SWT.NONE);
		label_51.setText("20");
		label_51.setBounds(190, 83, 15, 15);
		
		Label label_52 = new Label(grpAbilityScores, SWT.NONE);
		label_52.setText("20");
		label_52.setBounds(190, 62, 15, 15);
		
		Label label_53 = new Label(grpAbilityScores, SWT.NONE);
		label_53.setText("-");
		label_53.setBounds(175, 167, 15, 15);
		
		Label label_54 = new Label(grpAbilityScores, SWT.NONE);
		label_54.setText("-");
		label_54.setBounds(175, 146, 15, 15);
		
		Label label_55 = new Label(grpAbilityScores, SWT.NONE);
		label_55.setText("-");
		label_55.setBounds(175, 125, 15, 15);
		
		Label label_56 = new Label(grpAbilityScores, SWT.NONE);
		label_56.setText("-");
		label_56.setBounds(175, 104, 15, 15);
		
		Label label_57 = new Label(grpAbilityScores, SWT.NONE);
		label_57.setText("-");
		label_57.setBounds(175, 83, 15, 15);
		
		Label label_58 = new Label(grpAbilityScores, SWT.NONE);
		label_58.setText("-");
		label_58.setBounds(175, 60, 15, 15);
		
		Label label_59 = new Label(grpAbilityScores, SWT.NONE);
		label_59.setText("20");
		label_59.setBounds(226, 167, 15, 15);
		
		Label label_60 = new Label(grpAbilityScores, SWT.NONE);
		label_60.setText("20");
		label_60.setBounds(226, 146, 15, 15);
		
		Label label_61 = new Label(grpAbilityScores, SWT.NONE);
		label_61.setText("20");
		label_61.setBounds(226, 125, 15, 15);
		
		Label label_62 = new Label(grpAbilityScores, SWT.NONE);
		label_62.setText("20");
		label_62.setBounds(226, 104, 15, 15);
		
		Label label_63 = new Label(grpAbilityScores, SWT.NONE);
		label_63.setText("20");
		label_63.setBounds(226, 83, 15, 15);
		
		Label label_64 = new Label(grpAbilityScores, SWT.NONE);
		label_64.setText("20");
		label_64.setBounds(226, 62, 15, 15);
		
		Group grpSavingThrows = new Group(composite, SWT.NONE);
		grpSavingThrows.setText("Saving Throws");
		grpSavingThrows.setBounds(10, 201, 270, 111);
		
		Label lblFortitude = new Label(grpSavingThrows, SWT.NONE);
		lblFortitude.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblFortitude.setBounds(10, 44, 60, 15);
		lblFortitude.setText("Fortitude");
		
		Label lblReflex = new Label(grpSavingThrows, SWT.NONE);
		lblReflex.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblReflex.setText("Reflex");
		lblReflex.setBounds(10, 65, 60, 15);
		
		Label lblWill = new Label(grpSavingThrows, SWT.NONE);
		lblWill.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblWill.setText("Will");
		lblWill.setBounds(10, 86, 60, 15);
		
		Label label_17 = new Label(grpSavingThrows, SWT.NONE);
		label_17.setBounds(76, 44, 15, 15);
		label_17.setText("00");
		
		Label label_18 = new Label(grpSavingThrows, SWT.NONE);
		label_18.setText("00");
		label_18.setBounds(76, 65, 15, 15);
		
		Label label_19 = new Label(grpSavingThrows, SWT.NONE);
		label_19.setText("00");
		label_19.setBounds(76, 86, 15, 15);
		
		Label label_20 = new Label(grpSavingThrows, SWT.NONE);
		label_20.setText("=");
		label_20.setBounds(97, 86, 15, 15);
		
		Label label_21 = new Label(grpSavingThrows, SWT.NONE);
		label_21.setText("=");
		label_21.setBounds(97, 65, 15, 15);
		
		Label label_22 = new Label(grpSavingThrows, SWT.NONE);
		label_22.setText("=");
		label_22.setBounds(97, 44, 15, 15);
		
		Label label_65 = new Label(grpSavingThrows, SWT.NONE);
		label_65.setText("00");
		label_65.setBounds(118, 86, 15, 15);
		
		Label label_66 = new Label(grpSavingThrows, SWT.NONE);
		label_66.setText("00");
		label_66.setBounds(118, 65, 15, 15);
		
		Label label_67 = new Label(grpSavingThrows, SWT.NONE);
		label_67.setText("00");
		label_67.setBounds(118, 44, 15, 15);
		
		Label label_68 = new Label(grpSavingThrows, SWT.NONE);
		label_68.setText("+");
		label_68.setBounds(139, 86, 15, 15);
		
		Label label_69 = new Label(grpSavingThrows, SWT.NONE);
		label_69.setText("+");
		label_69.setBounds(139, 65, 15, 15);
		
		Label label_70 = new Label(grpSavingThrows, SWT.NONE);
		label_70.setText("+");
		label_70.setBounds(139, 44, 15, 15);
		
		Label label_71 = new Label(grpSavingThrows, SWT.NONE);
		label_71.setText("00");
		label_71.setBounds(149, 86, 15, 15);
		
		Label label_72 = new Label(grpSavingThrows, SWT.NONE);
		label_72.setText("00");
		label_72.setBounds(149, 65, 15, 15);
		
		Label label_73 = new Label(grpSavingThrows, SWT.NONE);
		label_73.setText("00");
		label_73.setBounds(149, 44, 15, 15);
		
		Label label_74 = new Label(grpSavingThrows, SWT.NONE);
		label_74.setText("+");
		label_74.setBounds(170, 44, 15, 15);
		
		Label label_75 = new Label(grpSavingThrows, SWT.NONE);
		label_75.setText("00");
		label_75.setBounds(180, 44, 15, 15);
		
		Label label_76 = new Label(grpSavingThrows, SWT.NONE);
		label_76.setText("+");
		label_76.setBounds(170, 65, 15, 15);
		
		Label label_77 = new Label(grpSavingThrows, SWT.NONE);
		label_77.setText("00");
		label_77.setBounds(180, 65, 15, 15);
		
		Label label_78 = new Label(grpSavingThrows, SWT.NONE);
		label_78.setText("+");
		label_78.setBounds(170, 86, 15, 15);
		
		Label label_79 = new Label(grpSavingThrows, SWT.NONE);
		label_79.setText("00");
		label_79.setBounds(180, 86, 15, 15);
		
		Label label_80 = new Label(grpSavingThrows, SWT.NONE);
		label_80.setText("+");
		label_80.setBounds(201, 44, 15, 15);
		
		Label label_81 = new Label(grpSavingThrows, SWT.NONE);
		label_81.setText("00");
		label_81.setBounds(211, 44, 15, 15);
		
		Label label_82 = new Label(grpSavingThrows, SWT.NONE);
		label_82.setText("+");
		label_82.setBounds(201, 65, 15, 15);
		
		Label label_83 = new Label(grpSavingThrows, SWT.NONE);
		label_83.setText("00");
		label_83.setBounds(211, 65, 15, 15);
		
		Label label_84 = new Label(grpSavingThrows, SWT.NONE);
		label_84.setText("+");
		label_84.setBounds(201, 86, 15, 15);
		
		Label label_85 = new Label(grpSavingThrows, SWT.NONE);
		label_85.setText("00");
		label_85.setBounds(211, 86, 15, 15);
		
		Label label_86 = new Label(grpSavingThrows, SWT.NONE);
		label_86.setText("+");
		label_86.setBounds(232, 44, 15, 15);
		
		Label label_87 = new Label(grpSavingThrows, SWT.NONE);
		label_87.setText("00");
		label_87.setBounds(242, 44, 15, 15);
		
		Label label_88 = new Label(grpSavingThrows, SWT.NONE);
		label_88.setText("+");
		label_88.setBounds(232, 65, 15, 15);
		
		Label label_89 = new Label(grpSavingThrows, SWT.NONE);
		label_89.setText("00");
		label_89.setBounds(242, 65, 15, 15);
		
		Label label_90 = new Label(grpSavingThrows, SWT.NONE);
		label_90.setText("+");
		label_90.setBounds(232, 86, 15, 15);
		
		Label label_91 = new Label(grpSavingThrows, SWT.NONE);
		label_91.setText("00");
		label_91.setBounds(242, 86, 15, 15);
		
		Button button = new Button(composite, SWT.NONE);
		button.setBounds(272, 71, 40, 15);
		button.setText("Roll");
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Roll");
		button_1.setBounds(272, 92, 40, 15);
		
		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setText("Roll");
		button_2.setBounds(272, 113, 40, 15);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Roll");
		button_3.setBounds(272, 134, 40, 15);
		
		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setText("Roll");
		button_4.setBounds(272, 155, 40, 15);
		
		Button button_5 = new Button(composite, SWT.NONE);
		button_5.setText("Roll");
		button_5.setBounds(272, 176, 40, 15);
		
		Group grpCharacter = new Group(composite, SWT.NONE);
		grpCharacter.setText("Character");
		grpCharacter.setBounds(318, 10, 288, 213);
		
		txtCharacterName = new Text(grpCharacter, SWT.BORDER);
		txtCharacterName.setText("Player Name");
		txtCharacterName.setBounds(150, 49, 130, 21);
		
		txtCharacterName_1 = new Text(grpCharacter, SWT.BORDER);
		txtCharacterName_1.setText("Character Name");
		txtCharacterName_1.setBounds(10, 49, 130, 21);
		
		Label lblCharacterName = new Label(grpCharacter, SWT.NONE);
		lblCharacterName.setBounds(10, 28, 96, 15);
		lblCharacterName.setText("Character Name");
		
		Label lblPlayerName = new Label(grpCharacter, SWT.NONE);
		lblPlayerName.setBounds(150, 28, 86, 15);
		lblPlayerName.setText("Player Name");
		
		Label lblSize = new Label(grpCharacter, SWT.NONE);
		lblSize.setBounds(10, 80, 34, 15);
		lblSize.setText("Size");
		
		ToolBar toolBar = new ToolBar(grpCharacter, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(35, 76, 89, 23);
		
		ToolItem tltmTitanic = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmTitanic.setText("Titanic");
		
		ToolItem tltmCollosal = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmCollosal.setText("Collosal");
		
		ToolItem tltmGigantic = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmGigantic.setText("Gigantic");
		
		ToolItem tltmLarge = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmLarge.setText("Large");
		
		ToolItem tltmMedium = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmMedium.setText("Medium");
		
		ToolItem tltmSmall = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmSmall.setText("Small");
		
		ToolItem tltmDiminuitive = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmDiminuitive.setText("Diminuitive");
		
		ToolItem tltmFine = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmFine.setText("Fine");
		
		Label lblGender = new Label(grpCharacter, SWT.NONE);
		lblGender.setBounds(141, 80, 44, 15);
		lblGender.setText("Gender");
		
		ToolBar toolBar_1 = new ToolBar(grpCharacter, SWT.FLAT | SWT.RIGHT);
		toolBar_1.setBounds(191, 76, 89, 23);
		
		ToolItem tltmFemale = new ToolItem(toolBar_1, SWT.DROP_DOWN);
		tltmFemale.setText("Female");
		
		ToolItem tltmNondescript = new ToolItem(toolBar_1, SWT.DROP_DOWN);
		tltmNondescript.setText("Nondescript");
		
		ToolItem tltmMale = new ToolItem(toolBar_1, SWT.DROP_DOWN);
		tltmMale.setText("Male");
		
		Label lblNewLabel_1 = new Label(grpCharacter, SWT.NONE);
		lblNewLabel_1.setBounds(10, 110, 55, 15);
		lblNewLabel_1.setText("Morality");
		
		Alignment alignment = new Alignment();
		
		ToolBar toolBar_2 = new ToolBar(grpCharacter, SWT.FLAT | SWT.RIGHT);
		toolBar_2.setBounds(10, 131, 89, 23);
		
		ToolItem tltmGood = new ToolItem(toolBar_2, SWT.DROP_DOWN);
		tltmGood.addSelectionListener(alignment);
		tltmGood.setText("Good");
		
		ToolItem tltmNeutral = new ToolItem(toolBar_2, SWT.DROP_DOWN);
		tltmNeutral.addSelectionListener(alignment);
		tltmNeutral.setText("Neutral");
		
		ToolItem tltmEvil = new ToolItem(toolBar_2, SWT.DROP_DOWN);
		tltmEvil.addSelectionListener(alignment);
		tltmEvil.setText("Evil");
		
		Label lblOrder = new Label(grpCharacter, SWT.NONE);
		lblOrder.setBounds(10, 160, 55, 15);
		lblOrder.setText("Order");
		
		ToolBar toolBar_3 = new ToolBar(grpCharacter, SWT.FLAT | SWT.RIGHT);
		toolBar_3.setBounds(10, 180, 89, 23);
		
		ToolItem tltmLawful = new ToolItem(toolBar_3, SWT.DROP_DOWN);
		tltmLawful.addSelectionListener(alignment);
		tltmLawful.setText("Lawful");
		
		ToolItem tltmNeutral_1 = new ToolItem(toolBar_3, SWT.DROP_DOWN);
		tltmNeutral_1.addSelectionListener(alignment);
		tltmNeutral_1.setText("Neutral");
		
		ToolItem tltmChaotic = new ToolItem(toolBar_3, SWT.DROP_DOWN);
		tltmChaotic.addSelectionListener(alignment);
		tltmChaotic.setText("Chaotic");
		
		Label lblNewLabel_2 = new Label(grpCharacter, SWT.NONE);
		lblNewLabel_2.setBounds(107, 110, 173, 93);
		lblNewLabel_2.setText(alignment.getAlignment());

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			action = new Action("Save Character") {
			};
		}
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		{
			MenuManager menuManager_1 = new MenuManager("File");
			menuManager.add(menuManager_1);
			menuManager_1.add(action);
			menuManager_1.add(action);
		}
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			CharacterSheetUI window = new CharacterSheetUI();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(994, 713);
	}

}