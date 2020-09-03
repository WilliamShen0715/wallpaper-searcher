package hella;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

public class hello {
	static String search = "Miku";
	static int depth=10;
//	int finish=0;
    static int num = 1;
    static int set=0;
    static int page=1;
	static int lastpage=0;
	static boolean next=false;
	public static void searchStart(int set) throws IOException{
//		finish = 0;
    	boolean found=false;
    	page=0;
    	System.out.print("search:");
    	search = search.substring(0,1).toUpperCase()+search.substring(1);
        Util.makeDir(Util.picDir);
        Document doc = Jsoup.connect("https://wall.alphacoders.com/newest_wallpapers.php").get();
        Elements findTagClass = doc.select(".tags-info");
        Elements findTag = findTagClass.select("a[href~=^tags.php]");
        for(int i=0;i<depth;i++) {
        	for (int j = 0; j <findTag.size(); j++) {
            	Element e = findTag.get(j);
            	//System.out.println("tag traveling:"+e.text());
            	if(e.text().indexOf(search)>-1) {
            		doc = Jsoup.connect("https://wall.alphacoders.com/"+e.attr("href")).get();
            		UI.dialog.setText(UI.dialog.getText()+"\r\n"+"find successful.");
            		found=true;
            		break;
            	}
            }
            if(found) break;
            Elements next_page = doc.select("#next_page");
            doc = Jsoup.connect(next_page.attr("href")).get();
            findTagClass = doc.select(".tags-info");
            findTag = findTagClass.select("a[href~=^tags.php]");
            if(i!=depth-1) UI.dialog.setText(UI.dialog.getText()+"\r\n"+"Wait..."+(depth-i));
        }
        if(!found) {
        	UI.dialog.setText(UI.dialog.getText()+"\r\n"+search+" "+"Not found.");
        }else {
        	Elements elementClass = doc.select(".boxgrid");
            Elements elements = elementClass.select("a[href~=^big.php]");
            //System.out.println(elements.size());
//            if(num!=1) set+=6;
            for(;set<elements.size();set+=6) {
            	if(elements.size()-set<6) {
            		for (int j = set; j < elements.size(); j++) {
                        Element e = elements.get(j);
                        String filePath = Util.picDir ;//+ "//" + j;
                        //Util.makeDir(filePath);
                        UI.dialog.setText(UI.dialog.getText()+"\r\n"+e.attr("href"));
                        //System.out.println(filePath);
                        Document docInner = Jsoup.connect("https://wall.alphacoders.com/" + e.attr("href")).get();
                        Elements elementsClass = docInner.select(".img-container-desktop");
                        Elements elementsInner = elementsClass.select("a[href^=https://images]");
                        //System.out.println(elementsInner.size());
                        for (Element eInner : elementsInner) {
                            String picUrl = eInner.attr("href");
                            Util.downloadPic(picUrl, ""+num+".jpg"/*picUrl.substring(picUrl.lastIndexOf("/"))*/, filePath);
                            num++;
                        }
                    }
            	}else {
            		for (int j = set; j < set+6; j++) {
                        Element e = elements.get(j);
                        String filePath = Util.picDir ;
                        //Util.makeDir(filePath);
                        UI.dialog.setText(UI.dialog.getText()+"\r\n"+e.attr("href"));
                        //System.out.println(filePath);
                        Document docInner = Jsoup.connect("https://wall.alphacoders.com/" + e.attr("href")).get();
                        Elements elementsClass = docInner.select(".img-container-desktop");
                        Elements elementsInner = elementsClass.select("a[href^=https://images]");
                        //System.out.println(elementsInner.size());
                        for (Element eInner : elementsInner) {
                            String picUrl = eInner.attr("href");
                            Util.downloadPic(picUrl, ""+num+".jpg"/*picUrl.substring(picUrl.lastIndexOf("/"))*/, filePath);
                            num++;
                        }
                    }
            	}
            	System.out.println("get a set.");
            	if(!next) break;
            	else continue;
            }
			hello.set+=6;
			hello.page++;
            UI.dialog.setText(UI.dialog.getText()+"\r\n"+"Picture file: "+Util.picDir); 
//            finish = 1;
        }
	}
}