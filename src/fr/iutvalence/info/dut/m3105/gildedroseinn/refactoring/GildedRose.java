package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQualityAndSellInForAllItems();
	}

	public static void updateQualityAndSellInForAllItems()
	{
		for (int currItem = 0; currItem < items.size(); currItem++)
		{
			updateQualityForItem(currItem);

			updateSellInForItem(currItem);

			if (items.get(currItem).getSellIn() < 0)
			{
				updateQualityForOutdatedItem(currItem);
			}
		}
	}

	
	private static void updateQualityForOutdatedItem(int currItem) 
	{
		if ("Aged Brie".equals(items.get(currItem).getName())) 
		{
			if (items.get(currItem).getQuality() < 50)
			{
				items.get(currItem).setQuality(items.get(currItem).getQuality() + 1);
			}
		} 
		else 
		{
			if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(currItem).getName())) 
			{
				items.get(currItem).setQuality(0);
			} 
			else 
			{
				if (items.get(currItem).getQuality() > 0 && !"Sulfuras, Hand of Ragnaros".equals(items.get(currItem).getName()))
				{
					items.get(currItem).setQuality(items.get(currItem).getQuality() - 1);
				}
			}
		}
	}

		
	
	private static void updateSellInForItem(int currItem) {
		if (!"Sulfuras, Hand of Ragnaros".equals(items.get(currItem).getName()))
		{
			items.get(currItem).setSellIn(items.get(currItem).getSellIn() - 1);
		}
	}

	
	
	private static void updateQualityForItem(int currItem) {
		if (("Aged Brie".equals(items.get(currItem).getName())) 
		|| "Backstage passes to a TAFKAL80ETC concert".equals(items.get(currItem).getName())) 
		{
			if (items.get(currItem).getQuality() < 50)
			{
				items.get(currItem).setQuality(items.get(currItem).getQuality() + 1);

				if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(currItem).getName()) 
						&& items.get(currItem).getSellIn() < 11 && items.get(currItem).getQuality() < 50)
				{
					items.get(currItem).setQuality(items.get(currItem).getQuality() + 1);

					if (items.get(currItem).getSellIn() < 6 && items.get(currItem).getQuality() < 50)
					{
						items.get(currItem).setQuality(items.get(currItem).getQuality() + 1);
					}
				}
			}
		} 
		else  
		{
			if (items.get(currItem).getQuality() > 0)
			{
				if (!"Sulfuras, Hand of Ragnaros".equals(items.get(currItem).getName()))
				{
					items.get(currItem).setQuality(items.get(currItem).getQuality() - 1);
				}
			}
		}
	}

}