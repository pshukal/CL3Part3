import java.awt.*;
import java.util.Vector;

@SuppressWarnings("serial")
class BarChart extends Panel
{			   
	private int	barWidth = 20;

	private Vector<Integer>	data;
	private Vector<String>	dataLabels;
	private Vector<Color>	dataColors;

	public void paint(Graphics g)
	{
		setSize(200,250);
		Image duke = Toolkit.getDefaultToolkit().getImage("duke2.gif");
		g.drawImage(duke, 80, 10, this);

		// SER515 1 done
		if (data == null || dataLabels == null || dataColors == null)
			return;
		if (data.size() != dataLabels.size() || data.size() != dataColors.size())
			return;

		for (int i = 0; i < data.size(); i++)
		{				  
			int yposition = 100+i*barWidth;

			g.setColor(dataColors.elementAt(i));

			int barLength = (data.elementAt(i)).intValue();
			g.fillOval(100, yposition, barLength, barWidth);

			g.setColor(Color.black);
			g.drawString(dataLabels.elementAt(i), 20, yposition+10);
		}
	}

	public void setData(Vector<Integer> dataValues)
	{
		data = dataValues;
	}

	public void setLabels(Vector<String> labels)
	{
		dataLabels = labels;
	}

	public void setColors(Vector<Color> colors)
	{
		dataColors = colors;
	}
}
