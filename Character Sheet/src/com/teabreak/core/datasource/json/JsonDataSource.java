package com.teabreak.core.datasource.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.Skill;
import com.teabreak.core.datasource.DataSourceInterface;

public class JsonDataSource implements DataSourceInterface
{

	@Override
	public AspectsInterface getDateOfType(AspectsEnum dataType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, AspectsInterface> getDataSetOfType(
			AspectsEnum dataType)
	{

		String fileSearch = "";
		ArrayList<AspectsInterface> data = new ArrayList<AspectsInterface>();

		switch (dataType)
		{
		case Skill:
			// File regex search
			fileSearch = "*Skills.json";

			break;

		case Class:
			break;

		case Race:
			break;

		case Feat:
			break;

		case Spell:
			break;

		case Equipment:
			break;
		}

		// Find files

		// Parse Files
		return null;
	}

	private File findJsonFiles(String fileSearch)
	{
		return null;
	}

	private File findJsonFile(String fileName)
	{
		return null;
	}

	@Override
	public void putData(String filename, AspectsInterface data)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putDataSet(String filename,
			SortedMap<String, ? extends AspectsInterface> dataSet)
	{
		// TODO Auto-generated method stub
		
	}
}
