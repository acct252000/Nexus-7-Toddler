package com.helenssc.android.toddlertabletpublic;

import java.util.ArrayList;

/**
 * <h1>Toddler Tablet ToddlerList</h1>
 * Populates list of flashcards based on title
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class ToddlerList{

    private String listTitle;
    private ArrayList<ToddlerItem> itemList;
    private Integer lastIndex;
    private Boolean textList;


    /**
     * Creates a ToddlerList based on the title of the list desired
     * @param title String title of the list desired.
     *@returns nothing
     */

    public ToddlerList(String title){
        textList = false;
        listTitle = title;
        itemList = populateArray(title);
        lastIndex = itemList.size()-1;
    }

    /**
     * Gets title of list
     *@returns String list title
     */
    public String getListTitle(){
        return listTitle;
    }

    /**
     * Gets current array list of Toddler Items
     *@returns ArrayList of TodderItem
     */
    public ArrayList<ToddlerItem> getItemList(){
        return itemList;
    }

    /**
     * Gets last index of ToddlerItem list
     *@returns Integer last index number
     */
    public Integer getLastIndex() {
        return lastIndex;
    }

    /**
     * Returns whether or not a text list
     *@returns Booelan true if text list, false if not
     */
    public Boolean isTextList(){
        return textList;
    }

    /**
     * Populates ArrayList with desired ToddlerItems (flashcards)
     * @param listName String of list desired
     *@returns ArrayList of ToddlerItems to serve as flashcards
     */
    private ArrayList<ToddlerItem> populateArray(String listName){

        ArrayList<ToddlerItem> allToddlerItems = new ArrayList<ToddlerItem>();

        if (listName.equals("upper_case")) {
            textList = false;
            lastIndex = 25;
            ToddlerItem a = new ToddlerItem("a", R.drawable.au, R.raw.a);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("b", R.drawable.bu, R.raw.b);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("c", R.drawable.cu, R.raw.c);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("d", R.drawable.du, R.raw.d);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("e", R.drawable.eu, R.raw.e);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("f", R.drawable.fu, R.raw.f);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("g", R.drawable.gu, R.raw.g);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("h", R.drawable.hu, R.raw.h);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("i", R.drawable.iu, R.raw.i);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("j", R.drawable.ju, R.raw.j);
            allToddlerItems.add(j);
            ToddlerItem k = new ToddlerItem("k", R.drawable.ku, R.raw.k);
            allToddlerItems.add(k);
            ToddlerItem l = new ToddlerItem("l", R.drawable.lu, R.raw.l);
            allToddlerItems.add(l);
            ToddlerItem m = new ToddlerItem("m", R.drawable.mu, R.raw.m);
            allToddlerItems.add(m);
            ToddlerItem n = new ToddlerItem("n", R.drawable.nu, R.raw.n);
            allToddlerItems.add(n);
            ToddlerItem o = new ToddlerItem("o", R.drawable.ou, R.raw.o);
            allToddlerItems.add(o);
            ToddlerItem p = new ToddlerItem("p", R.drawable.pu, R.raw.p);
            allToddlerItems.add(p);
            ToddlerItem q = new ToddlerItem("q", R.drawable.qu, R.raw.q);
            allToddlerItems.add(q);
            ToddlerItem r = new ToddlerItem("r", R.drawable.ru, R.raw.r);
            allToddlerItems.add(r);
            ToddlerItem s = new ToddlerItem("s", R.drawable.su, R.raw.s);
            allToddlerItems.add(s);
            ToddlerItem t = new ToddlerItem("t", R.drawable.tu, R.raw.t);
            allToddlerItems.add(t);
            ToddlerItem u = new ToddlerItem("u", R.drawable.uu, R.raw.u);
            allToddlerItems.add(u);
            ToddlerItem v = new ToddlerItem("v", R.drawable.vu, R.raw.v);
            allToddlerItems.add(v);
            ToddlerItem w = new ToddlerItem("w", R.drawable.wu, R.raw.w);
            allToddlerItems.add(w);
            ToddlerItem x = new ToddlerItem("x", R.drawable.xu, R.raw.x);
            allToddlerItems.add(x);
            ToddlerItem y = new ToddlerItem("y", R.drawable.yu, R.raw.y);
            allToddlerItems.add(y);
            ToddlerItem z = new ToddlerItem("z", R.drawable.zu, R.raw.z);
            allToddlerItems.add(z);

        }

        if (listName.equals("lower_case")) {
            textList = false;
            lastIndex = 25;
            ToddlerItem a = new ToddlerItem("a", R.drawable.a, R.raw.a);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("b", R.drawable.b, R.raw.b);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("c", R.drawable.c, R.raw.c);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("d", R.drawable.d, R.raw.d);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("e", R.drawable.e, R.raw.e);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("f", R.drawable.f, R.raw.f);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("g", R.drawable.g, R.raw.g);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("h", R.drawable.h, R.raw.h);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("i", R.drawable.i, R.raw.i);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("j", R.drawable.j, R.raw.j);
            allToddlerItems.add(j);
            ToddlerItem k = new ToddlerItem("k", R.drawable.k, R.raw.k);
            allToddlerItems.add(k);
            ToddlerItem l = new ToddlerItem("l", R.drawable.l, R.raw.l);
            allToddlerItems.add(l);
            ToddlerItem m = new ToddlerItem("m", R.drawable.m, R.raw.m);
            allToddlerItems.add(m);
            ToddlerItem n = new ToddlerItem("n", R.drawable.n, R.raw.n);
            allToddlerItems.add(n);
            ToddlerItem o = new ToddlerItem("o", R.drawable.o, R.raw.o);
            allToddlerItems.add(o);
            ToddlerItem p = new ToddlerItem("p", R.drawable.p, R.raw.p);
            allToddlerItems.add(p);
            ToddlerItem q = new ToddlerItem("q", R.drawable.q, R.raw.q);
            allToddlerItems.add(q);
            ToddlerItem r = new ToddlerItem("r", R.drawable.r, R.raw.r);
            allToddlerItems.add(r);
            ToddlerItem s = new ToddlerItem("s", R.drawable.s, R.raw.s);
            allToddlerItems.add(s);
            ToddlerItem t = new ToddlerItem("t", R.drawable.t, R.raw.t);
            allToddlerItems.add(t);
            ToddlerItem u = new ToddlerItem("u", R.drawable.u, R.raw.u);
            allToddlerItems.add(u);
            ToddlerItem v = new ToddlerItem("v", R.drawable.v, R.raw.v);
            allToddlerItems.add(v);
            ToddlerItem w = new ToddlerItem("w", R.drawable.w, R.raw.w);
            allToddlerItems.add(w);
            ToddlerItem x = new ToddlerItem("x", R.drawable.x, R.raw.x);
            allToddlerItems.add(x);
            ToddlerItem y = new ToddlerItem("y", R.drawable.y, R.raw.y);
            allToddlerItems.add(y);
            ToddlerItem z = new ToddlerItem("z", R.drawable.z, R.raw.z);
            allToddlerItems.add(z);
        }

        if (listName.equals("upper_lower")) {
            textList = false;
            lastIndex = 25;
            ToddlerItem a = new ToddlerItem("a", R.drawable.aul, R.raw.a);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("b", R.drawable.bul, R.raw.b);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("c", R.drawable.cul, R.raw.c);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("d", R.drawable.dul, R.raw.d);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("e", R.drawable.eul, R.raw.e);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("f", R.drawable.ful, R.raw.f);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("g", R.drawable.gul, R.raw.g);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("h", R.drawable.hul, R.raw.h);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("i", R.drawable.iul, R.raw.i);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("j", R.drawable.jul, R.raw.j);
            allToddlerItems.add(j);
            ToddlerItem k = new ToddlerItem("k", R.drawable.kul, R.raw.k);
            allToddlerItems.add(k);
            ToddlerItem l = new ToddlerItem("l", R.drawable.lul, R.raw.l);
            allToddlerItems.add(l);
            ToddlerItem m = new ToddlerItem("m", R.drawable.mul, R.raw.m);
            allToddlerItems.add(m);
            ToddlerItem n = new ToddlerItem("n", R.drawable.nul, R.raw.n);
            allToddlerItems.add(n);
            ToddlerItem o = new ToddlerItem("o", R.drawable.oul, R.raw.o);
            allToddlerItems.add(o);
            ToddlerItem p = new ToddlerItem("p", R.drawable.pul, R.raw.p);
            allToddlerItems.add(p);
            ToddlerItem q = new ToddlerItem("q", R.drawable.qul, R.raw.q);
            allToddlerItems.add(q);
            ToddlerItem r = new ToddlerItem("r", R.drawable.rul, R.raw.r);
            allToddlerItems.add(r);
            ToddlerItem s = new ToddlerItem("s", R.drawable.sul, R.raw.s);
            allToddlerItems.add(s);
            ToddlerItem t = new ToddlerItem("t", R.drawable.tul, R.raw.t);
            allToddlerItems.add(t);
            ToddlerItem u = new ToddlerItem("u", R.drawable.uul, R.raw.u);
            allToddlerItems.add(u);
            ToddlerItem v = new ToddlerItem("v", R.drawable.vul, R.raw.v);
            allToddlerItems.add(v);
            ToddlerItem w = new ToddlerItem("w", R.drawable.wul, R.raw.w);
            allToddlerItems.add(w);
            ToddlerItem x = new ToddlerItem("x", R.drawable.xul, R.raw.x);
            allToddlerItems.add(x);
            ToddlerItem y = new ToddlerItem("y", R.drawable.yul, R.raw.y);
            allToddlerItems.add(y);
            ToddlerItem z = new ToddlerItem("z", R.drawable.zul, R.raw.z);
            allToddlerItems.add(z);

        }


        if (listName.equals("one_to_ten")) {
            textList = false;
            lastIndex = 9;
            ToddlerItem a = new ToddlerItem("1", R.drawable.one, R.raw.one);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("2", R.drawable.two, R.raw.two);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("3", R.drawable.three, R.raw.three);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("4", R.drawable.four, R.raw.four);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("5", R.drawable.five, R.raw.five);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("6", R.drawable.six, R.raw.six);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("7", R.drawable.seven, R.raw.seven);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("8", R.drawable.eight, R.raw.eight);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("9", R.drawable.nine, R.raw.nine);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("10", R.drawable.ten, R.raw.ten);
            allToddlerItems.add(j);

        }

        if (listName.equals("eleven_to_twenty")) {
            textList = false;
            lastIndex = 9;
            ToddlerItem a = new ToddlerItem("11", R.drawable.eleven, R.raw.eleven);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("12", R.drawable.twelve, R.raw.twelve);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("13", R.drawable.thirteen, R.raw.thirteen);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("14", R.drawable.fourteen, R.raw.fourteen);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("15", R.drawable.fifteen, R.raw.fifteen);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("16", R.drawable.sixteen, R.raw.sixteen);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("17", R.drawable.seventeen, R.raw.seventeen);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("18", R.drawable.eighteen, R.raw.eighteen);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("19", R.drawable.nineteen, R.raw.nineteen);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("20", R.drawable.twenty, R.raw.twenty);
            allToddlerItems.add(j);

        }

        if (listName.equals("tens")) {
            textList = false;
            lastIndex = 7;
            ToddlerItem a = new ToddlerItem("30", R.drawable.thirty, R.raw.thirty);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("40", R.drawable.forty, R.raw.forty);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("50", R.drawable.fifty, R.raw.fifty);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("60", R.drawable.sixty, R.raw.sixty);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("70", R.drawable.seventy, R.raw.seventy);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("80", R.drawable.eighty, R.raw.eighty);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("90", R.drawable.ninety, R.raw.ninety);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("100", R.drawable.onehundred, R.raw.onehundred);
            allToddlerItems.add(h);


        }



        if (listName.equals("pictures")) {
            textList = false;
            lastIndex = 2;
            ToddlerItem a = new ToddlerItem("picture1", R.drawable.picture1, R.raw.picture1);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("picture2", R.drawable.picture2, R.raw.picture2);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("picture3", R.drawable.picture3, R.raw.picture3);
            allToddlerItems.add(c);
        }

        /*animals list name is commented out in public version as animal picture vectors are not publicly
        available.  To enable create your own drawables as indicated

        if (listName.equals("animals")) {
            textList = false;
            lastIndex = 20;
            ToddlerItem a = new ToddlerItem("alligator", R.drawable.alligator, R.raw.alligator);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("bear", R.drawable.bear, R.raw.bear);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("bunny", R.drawable.bunny, R.raw.bunny);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("cat", R.drawable.cat, R.raw.cat);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("cow", R.drawable.cow, R.raw.cow);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("dog", R.drawable.dog, R.raw.dog);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("donkey", R.drawable.donkey, R.raw.donkey);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("duck", R.drawable.duck, R.raw.duck);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("elephant", R.drawable.elephant, R.raw.elephant);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("frog", R.drawable.frog, R.raw.frog);
            allToddlerItems.add(j);
            ToddlerItem k = new ToddlerItem("giraffe", R.drawable.giraffe, R.raw.giraffe);
            allToddlerItems.add(k);
            ToddlerItem l = new ToddlerItem("goat", R.drawable.goat, R.raw.goat);
            allToddlerItems.add(l);
            ToddlerItem m = new ToddlerItem("hippo", R.drawable.hippo, R.raw.hippo);
            allToddlerItems.add(m);
            ToddlerItem n = new ToddlerItem("koala", R.drawable.koala, R.raw.koala);
            allToddlerItems.add(n);
            ToddlerItem o = new ToddlerItem("lion", R.drawable.lion, R.raw.lion);
            allToddlerItems.add(o);
            ToddlerItem p = new ToddlerItem("panda", R.drawable.panda, R.raw.panda);
            allToddlerItems.add(p);
            ToddlerItem q = new ToddlerItem("penguin", R.drawable.penguin, R.raw.penguin);
            allToddlerItems.add(q);
            ToddlerItem r = new ToddlerItem("pig", R.drawable.pig, R.raw.pig);
            allToddlerItems.add(r);
            ToddlerItem s = new ToddlerItem("polarbear", R.drawable.polarbear, R.raw.polarbear);
            allToddlerItems.add(s);
            ToddlerItem t = new ToddlerItem("porcupine", R.drawable.porcupine, R.raw.porcupine);
            allToddlerItems.add(t);
            ToddlerItem u = new ToddlerItem("sheep", R.drawable.sheep, R.raw.sheep);
            allToddlerItems.add(u);


        }
    */
        if (listName.equals("colors")) {
            textList = false;
            lastIndex = 10;
            ToddlerItem a = new ToddlerItem("black", R.drawable.black, R.raw.black);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("blue", R.drawable.blue, R.raw.blue);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("brown", R.drawable.brown, R.raw.brown);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("green", R.drawable.green, R.raw.green);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("grey", R.drawable.grey, R.raw.grey);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("orange", R.drawable.orange, R.raw.orange);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("pink", R.drawable.pink, R.raw.pink);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("purple", R.drawable.purple, R.raw.purple);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("red", R.drawable.red, R.raw.red);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("white", R.drawable.white, R.raw.white);
            allToddlerItems.add(j);
            ToddlerItem k = new ToddlerItem("yellow", R.drawable.yellow, R.raw.yellow);
            allToddlerItems.add(k);

        }


        if (listName.equals("shapes")) {
            textList = false;
            lastIndex = 11;
            ToddlerItem a = new ToddlerItem("square", R.drawable.square, R.raw.square);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("rectangle", R.drawable.rectangle, R.raw.rectangle);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("circle", R.drawable.circle, R.raw.circle);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("oval", R.drawable.oval, R.raw.oval);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("pentagon", R.drawable.pentagon, R.raw.pentagon);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("hexagon", R.drawable.hexagon, R.raw.hexagon);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("octagon", R.drawable.octagon, R.raw.octagon);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("triangle", R.drawable.triangle, R.raw.triangle);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("semicircle", R.drawable.semicircle, R.raw.semicircle);
            allToddlerItems.add(i);
            ToddlerItem l = new ToddlerItem("star", R.drawable.star, R.raw.star);
            allToddlerItems.add(l);



        }

        if (listName.equals("dolch_sightwords")) {
            textList = true;
            lastIndex = 25;
            ToddlerItem a = new ToddlerItem("a", R.drawable.aul, R.raw.a);
            allToddlerItems.add(a);
            ToddlerItem b = new ToddlerItem("and", R.drawable.bul, R.raw.and);
            allToddlerItems.add(b);
            ToddlerItem c = new ToddlerItem("away", R.drawable.cul, R.raw.away);
            allToddlerItems.add(c);
            ToddlerItem d = new ToddlerItem("big", R.drawable.dul, R.raw.big);
            allToddlerItems.add(d);
            ToddlerItem e = new ToddlerItem("blue", R.drawable.eul, R.raw.blue);
            allToddlerItems.add(e);
            ToddlerItem f = new ToddlerItem("can", R.drawable.ful, R.raw.can);
            allToddlerItems.add(f);
            ToddlerItem g = new ToddlerItem("come", R.drawable.gul, R.raw.come);
            allToddlerItems.add(g);
            ToddlerItem h = new ToddlerItem("down", R.drawable.hul, R.raw.down);
            allToddlerItems.add(h);
            ToddlerItem i = new ToddlerItem("find", R.drawable.iul, R.raw.find);
            allToddlerItems.add(i);
            ToddlerItem j = new ToddlerItem("for", R.drawable.jul, R.raw.four);
            allToddlerItems.add(j);
            ToddlerItem k = new ToddlerItem("funny", R.drawable.kul, R.raw.funny);
            allToddlerItems.add(k);
            ToddlerItem l = new ToddlerItem("go", R.drawable.lul, R.raw.go);
            allToddlerItems.add(l);
            ToddlerItem m = new ToddlerItem("help", R.drawable.mul, R.raw.help);
            allToddlerItems.add(m);
            ToddlerItem n = new ToddlerItem("here", R.drawable.nul, R.raw.here);
            allToddlerItems.add(n);
            ToddlerItem o = new ToddlerItem("I", R.drawable.oul, R.raw.i);
            allToddlerItems.add(o);
            ToddlerItem p = new ToddlerItem("in", R.drawable.pul, R.raw.in);
            allToddlerItems.add(p);
            ToddlerItem q = new ToddlerItem("is", R.drawable.qul, R.raw.is);
            allToddlerItems.add(q);
            ToddlerItem r = new ToddlerItem("it", R.drawable.rul, R.raw.it);
            allToddlerItems.add(r);
            ToddlerItem s = new ToddlerItem("jump", R.drawable.sul, R.raw.jump);
            allToddlerItems.add(s);
            ToddlerItem t = new ToddlerItem("little", R.drawable.tul, R.raw.little);
            allToddlerItems.add(t);
            ToddlerItem u = new ToddlerItem("look", R.drawable.uul, R.raw.look);
            allToddlerItems.add(u);
            ToddlerItem v = new ToddlerItem("make", R.drawable.vul, R.raw.make);
            allToddlerItems.add(v);
            ToddlerItem w = new ToddlerItem("me", R.drawable.wul, R.raw.me);
            allToddlerItems.add(w);
            ToddlerItem x = new ToddlerItem("my", R.drawable.xul, R.raw.my);
            allToddlerItems.add(x);
            ToddlerItem y = new ToddlerItem("not", R.drawable.yul, R.raw.not);
            allToddlerItems.add(y);
            ToddlerItem z = new ToddlerItem("one", R.drawable.zul, R.raw.one);
            allToddlerItems.add(z);
            ToddlerItem aa = new ToddlerItem("play", R.drawable.zul, R.raw.play);
            allToddlerItems.add(aa);
            ToddlerItem ab = new ToddlerItem("red", R.drawable.zul, R.raw.red);
            allToddlerItems.add(ab);
            ToddlerItem ac = new ToddlerItem("run", R.drawable.zul, R.raw.run);
            allToddlerItems.add(ac);
            ToddlerItem ad = new ToddlerItem("said", R.drawable.zul, R.raw.said);
            allToddlerItems.add(ad);
            ToddlerItem ae = new ToddlerItem("see", R.drawable.zul, R.raw.see);
            allToddlerItems.add(ae);
            ToddlerItem af = new ToddlerItem("the", R.drawable.zul, R.raw.the);
            allToddlerItems.add(af);
            ToddlerItem ag = new ToddlerItem("three", R.drawable.zul, R.raw.three);
            allToddlerItems.add(ag);
            ToddlerItem ah = new ToddlerItem("to", R.drawable.zul, R.raw.two);
            allToddlerItems.add(ah);
            ToddlerItem ai = new ToddlerItem("two", R.drawable.zul, R.raw.two);
            allToddlerItems.add(ai);
            ToddlerItem aj = new ToddlerItem("up", R.drawable.zul, R.raw.up);
            allToddlerItems.add(aj);
            ToddlerItem ak = new ToddlerItem("we", R.drawable.zul, R.raw.we);
            allToddlerItems.add(ak);
            ToddlerItem al = new ToddlerItem("where", R.drawable.zul, R.raw.where);
            allToddlerItems.add(al);
            ToddlerItem am = new ToddlerItem("yellow", R.drawable.zul, R.raw.yellow);
            allToddlerItems.add(am);
            ToddlerItem an = new ToddlerItem("you", R.drawable.zul, R.raw.you);
            allToddlerItems.add(an);

        }


        return allToddlerItems;
    }


}

