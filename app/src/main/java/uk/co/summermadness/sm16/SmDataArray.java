package uk.co.summermadness.sm16;

/**
 * Created on 08/06/2016.
 */
public final class SmDataArray {

    // Alternatively could store these strings in an XML String Array resources file:  https://developer.android.com/guide/topics/resources/string-resource.html#StringArray
    // Or use custom array adapter : https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView

    // To locate the images, could use: String mDrawableName = "myappicon";
    // **** BUT this is slow!!!
    // int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
    // int drawableResourceId = this.getResources().getIdentifier("nameOfDrawable", "drawable", this.getPackageName());
    // In case you want a String in strings.xml or an identifier of a UI element, substitute "drawable"
    // int resourceId = this.getResources().getIdentifier("nameOfResource", "id", this.getPackageName

    public static final int dataVersion = 1;
    public static final String[][][] data = new String[][][]{
            { // 0: Welcome:
                    {"0", "Welcome", "red"},
                    {"0.1", "Welcome to Summer Madness 2016", "1st-5th July 2016 in Glenarm\n\n"
                            +"Summer Madness is a festival that brings together young people, from all backgrounds, across the island of Ireland to celebrate, connect and explore the significance of faith in today’s world."
                            +"\n\nWith over 100 hours of content our programme has something for everyone. From the Big Top sessions, through to sports, arts and crafts workshops and seminars ranging a wealth of subjects you’ll find numerous ways to have fun, build friendships and strengthen your faith."
                            +"\n\nWeb: http://www.summermadness.co.uk/festival/"
                    },

                    {"0.2", "Using this app", "This mobile app aims to be a quick way to find information about Summer madness 2016. The programme booklet contains more information."
                            +"\n\nThe \"Back arrow\", and \"Forward arrow\" icons in the menu bar at top right can be used to move between the pages."
                            +"\nOr you can select page from the drop-down menu by pressing the three vertical dots at the top-right"
                            +"\n\nIf a line in the list ends with \"...\" then tapping that line will display more details"
                            +"\n\nSM16 App version: 0.123,  11-June-2016"
                    },

                    {"0.3", "Activities", "SALT Factory Sports\nFeeling energetic? You are in for a real treat with our activities this year!"
                            + "\nWe always like a little competitive spirit and as usual, we have the annual 5 a-side football competition; but this year we have added in, Tug-of-War, Ultimate Frisbee, Dodgeball and Tag Rugby."
                            + "\nWe’ll also have the second ever Summer Madness, \"It’s a Knockout\" competition."
                            + "\nBack by popular demand is the sailing and canoeing in the harbour."
                            + "\nIn the Wigwam, where there will also be giant garden games to give you an easy excuse to act like a child - again!",
                            String.valueOf(R.drawable.activities_130)
                    },
                    {"0.4", "A Typical Day of Madness", "If you find yourself asking the question, ‘What does a day in the life of Summer Madness’ look like well here’s the answer…"},
                    {"0.5", "8am", "Emerge from your tent well rested and ready for the day. While you make use of the hot showers available in sub camp your group leader will prepare a nutritious breakfast to help fuel your day (If you follow your nose though you might make your way to the Christian Aid tent and treat yourself to a bacon buttie)."},
                    {"0.6", "9:45am", "Head to the Big Top with your group for the morning session starting with worship at 10am. This is followed by a mainstage talk from one of our guest speakers with the option of prayer ministry afterwards. If Big Top isn’t for you then head to the YFC venue for a more informal hang out space."},
                    {"0.7", "12:30pm", "After the morning session you can check out the exhibition area and chat to our mission and partner agencies from across Ireland and the world. This is open all afternoon until the evening session as well if you miss them now."},
                    {"0.8", "1pm", "It’s important to fuel up again before a busy afternoon of seminars and activities. You can either do this over your leaders mini-stove back in the sub camp or make use of one of our mobile food vendors. Either way, this is also an excellent time to talk with your group about the morning session and what you felt God was saying to you through it (PS: our food vendors are lovely folk who are open to group discounts if you book in advance)."},
                    {"0.9", "2-6pm", "The afternoon is yours to do with as you please. We have over 100 hours of seminar and activities on offer. Seminars to pick from include Preparing for Uni, Dance Workshops, Mental Health, Mission Opportunities, Peace and Reconciliation and so much more. And we have a wealth of activities to choose from including canoeing, sailing, football, dodgeball, slip ‘n’ slide and ultimate Frisbee. And if you’re just looking somewhere to chill there’s a couple of venues with a coffee and couch combo. At some point over the festival you will have to make sure you check out the hidden gem of Glenarm that is the Walled Garden."},
                    {"0.10", "6pm", "As the afternoon fades away gather your group back together for dinner and hear what everyone got up to in the afternoon. Don’t worry if you missed a seminar or two – they’re all recorded and available to buy at the end of the conference for £10."},
                    {"0.11", "6:45pm", "Head back to the Big Top or YFC venue for our evening session starting at 7pm."},
                    {"0.12", "9pm", "As the Big Top empties our evening venues fill up. Here, you can enjoy a variety of live music or grab a coffee and a chat with your mates."},
                    {"0.13", "11:30pm", "The venues go to bed for the night and so do you! Because it all starts again tomorrow morning bright and early. Our roving security team stay up during the night so give them a smile and a hug when you see them in the morning."},
            },

            { // 1: Info:
                    {"1", "Info", "red"},
                    {"1.1", "First Aid","The first aid team can be contacted at ....."},
                    {"1.2", "Fire", "In case of fire contact ......."},
                    {"1.3", "For youth leaders","See the Summer madness website for information: http://www.summermadness.co.uk/festival/project/leaders-info/"},
                    {"1.4", "For parents","Summer Madness is a conference aimed at young people, as such everyone under 18 needs to be accompanied by a leader. It is the leader who takes direct responsibility for the young person, however, we ensure the environment is fun, exciting and safe for all involved. We have a large volunteer team of over 200 people serving in different areas including Prayer Ministry, Welcome Team and Security ensuring all requirements are met. You may find answers to some of your questions in the leaders downloads above, however don’t hesitate to get in touch with us via the contact details below"
                            +"\nEmail: office@summermadness.co.uk"
                            +"\nPhone: 02890 673 379"},
                    {"1.5", "Web: http://www.summermadness.co.uk/"},
            },

            { // 2: Venues/Map:
                    {"2", "Venues/Map", "red"},
                    {"2.1", "The Big Top", "We love The Big Top and it offers such an intimate Worship space. There may be over 2000 people in it but often it feels like God puts his finger right on you. There are deliberately no arts programme in the Big Top, so there’s more time and freedom to engage with God without being rushed away or distracted by sound checks."},
                    {"2.2", "Tearfund Cafe", "Tearfund is a Christian international aid and development agency working globally to end poverty and injustice, and to restore dignity and hope in some of the world’s poorest communities. The Tearfund Café is located in the first courtyard and is a great place to hang out, learn more about their work and buy hot drinks and baked goods from Belfast-based coffee shop and social enterprise, Common Grounds."},
                    {"2.3", "DNA Tent", "DNA Tent is back again this year. The venue is a living exploration of what Ireland is, what we are called to be, and how God wants us to heal. It is a snapshot of God’s redemptive purpose for this island. Along with our small coffee pod will be a venue that is staffed by a team of committed workers from Urban Saints. We’re here to chat, pray and hangout. Come and see what we’re doing all over Ireland. Come and decorate our mural of hope and use it to pray for the land. Come and reflect on our call to be a light to the nations, Sign up for personal prayer from our team who will pray for your original design. What is your spiritual DNA from conception? Use your creativity!"},
                    {"2.4", "24/5 Prayer Room", "The prayer room is a creative and interactive space for you to come and spend time chatting with God through words, art, music, activity and silence. Our desire is that the prayer room will be a place where you meet with God, where you can process what God is saying to you throughout the festival and pray big prayers for your family, friends, church and the nation!"},
                    {"2.5", "The Campus", "...................."},
                    {"2.8", "Seminar One", "Located near entrance gate ...."},
                    {"2.9", "Seminar Two", "Located near entrance gate ...."},
                    {"2.10", "Seminar Three", "Located near entrance gate ...."},
                    {"2.11", "CIYD Connect", "Imagine a space of calm among the Madness. If you are a youth leader, youth worker, committed in your role among young people and you are craving a quiet space to escape the Madness, feel free to drop in, flop into a comfy sofa, enjoy FREE coffee and freshly baked goods. Whilst all goodies are free any donations made will go towards the Twin a Tent campaign for refugee crisis. CIYD welcomes you and your team to enjoy the comfort and calm of this little space."},
                    {"2.12", "YFC Drop-In", "Every afternoon and evening you will be able to pop into the venue and enjoy a game of pool or table tennis, have a go on the X-box or PS4; or just hang out and have a cuppa with one of the YFC Team. Throughout the day, there will also be various competitions and events for those of you who are up for the challenge and in the evening you can spend some time relaxing on one of the sofa’s and enjoy some live music from various local artists. Cage football will be located outside the YFC Drop In."},
                    {"2.13", "The Woodland Cafe", "The Woodland Cafe isn’t quite in the Woodland anymore, but hey! We still like the name! The good news is that we are right beside the food vendors, so if you are looking some shelter from the blistering sunshine or the odd light drizzle, this is the place for you. Run by the Methodist, Church of Ireland and Presbyterian Chaplaincies at Queen’s University, there’s a great selection of drinks, snacks, milkshakes and ice cream and plenty of folk around to ensure you’re well looked after. Somewhere to chill or take timeout from the busy festival."},
            },

            { // 3: Speakers
                    {"3", "Worship & Speakers", "red"},
                    {"3.1", "Bluetree - worship", "@bluetreeband\nComing from Belfast, Bluetree have been leading worship around the world since 2005 and are passionate about worship and justice. They are committed to pouring everything into building up the church for the glory of God and we’re delighted to be partnering with them at this year’s festival.",
                            String.valueOf(R.drawable.bluetree_130)},
                    {"3.2", "Stephen Mayes & Band - worship", "@stephen7m\nStephen is married to Abby and lives in Belfast. He is a worship leader with New Wine Ireland and this August will be joining Re:Hope Church to launch a new campus in the heart of Belfast City Centre. Stephen and his band desire to see people connect to the Father’s heart in worship by facilitating an atmosphere that encourages joy, intimacy and freedom to fully embrace the presence of the living God.",
                            String.valueOf(R.drawable.stephen_mayes_130)},
                    {"3.3", "Rachel Hughes - speaker", "@rachelemhughes\nRachel Hughes is married to Tim and they have 4 young children. They have recently moved from London (Holy Trinity Brompton/Alpha) where Rachel was involved in leading women’s ministry, and teaching. Tim & Rachel have just moved to Birmingham and planted a new church (St. Luke’s Gas Street) and are hugely excited about seeing what God will do there.",
                            String.valueOf(R.drawable.rachel_hughes_130)},
                    {"3.4", "Matt Summerfield - speaker", "@livelife123org\nMatt Summerfield balances his time between being the Chief Executive of Urban Saints and the Senior Pastor of Hitchin Christian Centre. Life is never dull! He’s passionate about releasing potential in people and organisations, with a particular bias towards seeing children and young people live God’s great adventure for their lives having been involved in youthwork for over 25 years. He is the founder of the lifelive123.org – a new movement of people committed to intentional, accountable disciple-making relationships. He loves Haagen Daaz Belgian Chocolate ice cream, meat feast pizzas and great movies.",
                            String.valueOf(R.drawable.matt_summerfield_130)},
                    {"3.5", "Adrian McCartney - speaker", "@adrianmccartney\n................."},
                    {"3.6", "Stu Bothwell - speaker", "@stubothwell\n.................."}
            },

            { // 4: Friday
                    {"4", "Friday", "green"},
                    {"4.1", "7pm - Mainstage Worship - Big Top", "Doors of Big Top open at 6.30pm\nLive-streamed into Mainstage Overflow in Tear fund cafe"},
                    {"4.2", "9:15pm - Tom McConnell - DNA Tent"},
                    {"4.2", "9:15pm - DJ Billy Fyffe - The Campus"},
                    {"4.2", "11pm - Jamie Neish - Seminar One"}
            },

            { // 5: Saturday
                    {"5", "Saturday", "green"},
                    {"5.1", "8am - Morning Bible study - The Campus", "Simon Lennox\nEnds: 8:45am"},
                    {"5.2", "8:45am - Group Time", "Journal on page 55\n\nEnds: 9:45am"},
                    {"5.3", "10am - Mainstage Worship - Big Top", "Doors of Big Top open at 9.30am\nLive-streamed into Mainstage Overflow in Tear fund cafe\n\nEnds: 12pm"},
                    {"5.4", "12pm - Building Relationships that Last -  CIYD Connect", "Matt Bird\n\nEnds: 1pm"},
                    {"5.5", "12pm - Workshop - The Campus", "Daniel Duke & Tom McConnell\n\nEnds: 1pm"},
                    {"5.6", "1pm - Tom McConnell - DNA Tent", "Ends: 2pm"},
                    {"5.7", "1pm - Daniel Duke - The Campus", "Ends: 2pm"},
                    {"5.8", "2pm - Spiritual Disciplines: INWARD - CIYD Connect", "CIYD Team\n\nEnds: 3pm"},
                    {"5.10", "2pm - Islam and Isis - Seminar Two" , "Your Questions answered, Jim Stewart and Abdul Azim\n\nEnds: 3pm"},
                    {"5.10", "2pm - Soul Sista - Seminar One" , "Secret Royals, Jill Boyd\n\nEnds: 3pm"},
                    {"5.11", "2pm - Making Disciples Who Make Disciples - DNA Tent", "Matt Summerfield, Urban Saints\n\nEnds: 3pm"},
                    {"5.12", "2pm - Mad Men: Falling in Love or Lust - Seminar Three", "Niall McNally\n\nEnds: 3pm"},
                    {"5.13", "3:15pm - Leadership: Rhythms & Rest - CIYD Connect", "Stu Bothwell\n\nEnds: 3pm"},
                    {"5.14", "3:15pm - Global Outreach Day - The Campus", "- Be a part of it. Jasper Rutherford\n\nEnds: 4:15pm"},
                    {"5.15", "3:15pm - But What can I Do? - Seminar Two", "Hannah Douglas, Teafund\n\nEnds: 4:15pm"},
                    {"5.16", "3:15pm - The Digital you - Seminar One", "Niall McNally\n\nEnds: 4:15pm"},
                    {"5.17", "3:15pm - Decommissioning Mindsets - DNA Tent", "James Wilson and Gladys Ganiel\n\nEnds: 4:15pm"},
                    {"5.18", "3:15pm - Friendship - Seminar Three", "I'll be there for you - Pete Waugh\n\nEnds: 4:15pm"},
                    {"5.19", "4:30pm - Preparing for University - The Campus", "Barry Forde & Guests\n\nEnds: 5:30pm"},
                    {"5.20", "4:30pm - Responding to the Refugee Crisis - Seminar Two", "MAP\n\nEnds: 5:30pm"},
                    {"5.21", "4:30pm - Does God Care What nationality You Are? - Seminar One", "Panel Discussion\n\nEnds: 5:30pm"},
                    {"5.22", "4:30pm - Dance Workshop - DNA Tent", "Vibe Academy\n\nEnds: 5:30pm"},
                    {"5.23", "4:30pm - The Curse of Quiet Time - Seminar Three", "David Dunlop\n\nEnds: 5:30pm"},
                    {"5.24", "7pm - Mainstage Worship - Big Top", "Doors of Big Top open at 6.30pm\n\nLive-streamed into Mainstage Overflow in Tear fund cafe\n\nEnds: 9pm"},
                    {"5.25", "7pm - Alternative to Mainstage - YFC Drop In", "Ends: 9pm"},
                    {"5.26", "9:15pm - Brash Isaac - The Campus","Ends: 10pm"},
                    {"5.27", "9:15pm - PTYK & Billy Fyffe - DNA Tent", "Alphabet Disco.\n\nEnds: 11pm"},
                    {"5.28", "10:15pm - Daniel Duke - The Campus","Ends: 11:15pm"}
            },

            { // 6: Sunday:
                    {"6", "Sunday", "green"},
                    {"6.1", "8am - Morning Bible study - The Campus", "Simon Lennox\nEnds: 8:45am"},
                    {"6.2", "8:45am - Group Time", "Journal on page 55\n\nEnds: 9:45am"},
                    {"6.3", "10am - Mainstage Worship - Big Top", "Doors of Big Top open at 9.30am\nLive-streamed into Mainstage Overflow in Tear fund cafe\n\nEnds: 12pm"},
                    {"6.4", "12pm - Authentic Intimacy -  CIYD Connect", "Worship Central\n\nEnds: 1pm"},
                    {"6.5", "1pm - Wildfire - The Campus", "Ends: 2pm"},
                    {"6.6", "1pm - Daniel Duke - DNA Tent", "Ends: 2pm"},

                    {"6.8", "2pm - Spiritual Disciplines: OUTWARD - CIYD Connect", "CIYD Team\n\nEnds: 3pm"},
                    {"6.9", "2pm - *BLANK in programme* - The Campus", "Ends: 3pm"},
                    {"6.10", "2pm - UnLearn Prayer - Seminar Two" , "Matt Summerfield\n\nEnds: 3pm"},
                    {"6.11", "2pm - Soul Sista - Seminar One" , "My Royal Subjects, Jill Boyd\n\nEnds: 3pm"},
                    {"6.12", "2pm - Spirit Radio Workshop - DNA Tent", ""},
                    {"6.13", "2pm - Mad Men: Warm bodies - Seminar Three", "Niall McNally\n\nEnds: 4.15pm"},

                    {"6.14", "3:15pm - Sensitive Conversations - CIYD Connect", "When It's Hard to Talk About What Really Matters, Donchadh Greene & Barry Forde\n\nEnds: 4.15pm"},
                    {"6.15", "3:15pm - Documenting Disaster - Seminar Two", "David Cavan, Tearfund\n\nEnds: 4.15pm"},
                    {"6.16", "3:15pm - Tails YOU Lose - Seminar One", "Justyn Ress Larcombe\n\nEnds: 4.15pm"},
                    {"6.17", "3:15pm - Jesus Followers - DNA Tent", "Matt Summerfield and Wilson Beare, Urban Saints\n\nEnds: 4.15pm"},
                    {"6.18", "3:15pm - The Cost Of Growing Up - The Campus", "CAP\n\nEnds: 4.15pm"},

                    {"6.19", "4:30pm - More Than a Bad Day - Seminar Two", "David Cavan, Tearfund\n\nEnds: 5:30pm"},
                    {"6.20", "4:30pm - Up Close & personal - Seminar One", "Panel Discussion\n\nEnds: 5:30pm"},
                    {"6.21", "4:30pm - Dance Workshop - DNA Tent", "Vibe Academy\n\nEnds: 5.30pm"},
                    {"6.22", "4.30pm - Evangelism -Anyone Can Do It! - Seminar Three", "Phil Timson\n\nEnds: 5:30pm"},

                    {"6.24", "7pm - Mainstage Worship - Big Top", "Doors of Big Top open at 6.30pm\n\nLive-streamed into Mainstage Overflow in Tear fund cafe\n\nEnds: 9pm"},
                    {"6.25", "7pm - Alternative to Mainstage - YFC Drop In", "Ends: 9pm"},

                    {"6.26", "9:15pm - Chris Wilson - The Campus","Ends: 10pm"},
                    {"6.27", "9:15pm - Mark Ferguson - DNA Tent", "Ends: 11pm"},
                    {"6.28", "10:15pm - Hillspeak - DNA Tent","Ends: 11:15pm"}

            },

            { // 7: Monday:
                    {"7", "Monday", "green"},
                    {"7.1", "8am - Morning Bible study - The Campus", "Simon Lennox\nEnds: 8:45am"},
                    {"7.2", "8:45am - Group Time", "Journal on page 55\n\nEnds: 9:45am"},
                    {"7.3", "10am - Mainstage Worship - Big Top", "Doors of Big Top open at 9.30am\nLive-streamed into Mainstage Overflow in Tear fund cafe\n\nEnds: 12pm"},
                    {"7.4", "10am - Alternative to Mainstage - YFC Drop In", "Ends: 12pm"},
                    {"7.5", "12:15pm - Illustrated Faith - DNA Tent", "Ends: 2pm"},
                    {"7.6", "1pm - Beulah Kim - The Campus", "Ends: 2pm"},
                    {"7.7", "1pm - Jamie Neish - DNA Tent", "Ends: 2pm"},
                    {"7.8", "2pm - Spiritual Disciplines: CORPORATE - CIYD Connect", "CIYD Team\n\nEnds: 3pm"},
                    {"7.9", "2pm - When I Pray What Does God Do? - The Campus", "Prof D Wilkinson\n\nEnds: 3pm"},
                    {"7.10", "2pm - If God Exists, Why Doesn't He Show Himself More Clearly? - Seminar Two" , "Dr David Glass\n\nEnds: 3pm"},
                    {"7.11", "2pm - Modern Romance: The Dating games - Seminar One" , "Stu Bothwell\n\nEnds: 3pm"},
                    {"7.12", "3:15pm - Leading Yourself Before Leading Others - CIYD Connect", "Rachel Hughes\n\nEnds: 4.15pm"},
                    {"7.13", "3:15pm - Guidance - Hearing God Speak For Yourself - The Campus", "Barry Forde\n\nEnds: 4.15pm"},
                    {"7.13", "3:15pm - The Church Around the Corner - Seminar Two", "Tom stewert, Cinnamon Network\n\nEnds: 4.15pm"},
                    {"7.14", "3:15pm - Real Families - Seminar One", "The Big House\n\nEnds: 4.15pm"},
                    {"7.15", "3:15pm - Five Ways to shape Your Culture - DNA Tent", "Emma Worrall, Open Doors\n\nEnds: 4.15pm"},
                    {"7.18", "3:15pm - Walking Free From Drug Addiction - Seminar Three", "John Edwards\n\nEnds: 4.15pm"},
                    {"7.19", "4:30pm - Can We Talk? - The Campus", "Will You Listen?, Sharon Hamil & Guests\n\nEnds: 5:30pm"},
                    {"7.20", "4:30pm - When Life Gets Difficult - Seminar Two", "MAP\n\nEnds: 5:30pm"},
                    {"7.21", "4.30pm - New Christians - Seminar Three", "Neville Barnes\n\nEnds: 5:30pm"},
                    {"7.22", "4:30pm - Opening Up The Bible - DNA Tent", "Precept Ministries\n\nEnds: 5.30pm"},
                    {"7.23", "7pm - Mainstage Worship - Big Top", "Doors of Big Top open at 6.30pm\n\nLive-streamed into Mainstage Overflow in Tear fund cafe\n\nEnds: 9pm"},
                    {"7.24", "9:15pm - David Walker - The Campus","Ends: 10pm"},
                    {"7.25", "9:15pm - PTYK UV Party - DNA Tent", "Ends: 11pm"}
            },

            { // 8: What Next:
                    {"8", "What Next", "red"},
                    {"8.1", "After Summer Madness 2016","Now that Summer Madness is over for 2016, what can I do now. Here are some ideas."},
                    {"8.2", "Total Recall", "Get the Total Recall USB stick with all the Mainstage talks and Seminars ...."},
                    {"8.3", "Your friends", "Tell and encourage your friends ...."},
                    {"8.4", "Your church", "Get involved at your church...."},
                    {"8.5", "Pray", "Pray for ...."},
                    {"8.6", "Study", "Bible reading notes ...."},
                    {"8.7", "Listen", "Audio of SM16 seminars from ......and other speakers... "},
                    {"8.8", "Ignite", "https://ignitecd.wordpress.com/"},
                    {"8.9", "Give", "Giving time and money ...."},
                    {"8.10", "Supporting missions", "Local and overseas ...."},
                    {"8.11", "Volunteer for SM 2017", "Volunteer to help run next year’s summer madness: http://www.summermadness.co.uk/festival/project/get-involved/"}
            },

            { // 9. Inbox: // Should really convert to an new ArrayList<String[]>() so can extend it
                    {"9", "Inbox", "red"},
                    {"9.1", "Your notifications inbox", "Any updates or changes to the Summer Madness programme will appear below."},
                    {}, {}, {}, {}, {},
                    {}, {}, {}, {}, {},
                    {}, {}, {}, {}, {},
                    {}, {}, {}, {}, {}
            }

    };
}
