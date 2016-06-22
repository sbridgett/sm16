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
    public static final String inboxChapter = "3";  // This inboxPage value is used for adding the notifications in MainActivity.add_notification_to_inbox(..)
    public static final String[][] data = new String[][]{
    // Use ’ rather than ' as SQL statements use ' for quotes, although all are prepared statements so will escape '
            // 1: Welcome:
            {"1", "Welcome", "red", ""},

            {"1.01", "Summer Madness 2016",   "1st-5th July 2016 in Glenarm\n\n"
                    +"Summer Madness is a festival that brings together young people, from all backgrounds, across the island of Ireland to celebrate, connect and explore the significance of faith in today’s world."
                    +"\n\nWith over 100 hours of content our programme has something for everyone. From the Big Top sessions, through to sports, arts and crafts workshops and seminars ranging a wealth of subjects you’ll find numerous ways to have fun, build friendships and strengthen your faith."
                    +"\n\nWeb: http://www.summermadness.co.uk/festival/",
                    ""
            },
            {"1.02", "Using this app",   "This mobile app aims to be a handy way to find information about Summer madness 2016. The excellent printed SM \"Up close + Personal, Festival guide 2016\" programme booklet contains more information."
                    +"\n\nThe \"SM16 Contents\", page is the main menu to the Sub-pages. Touching any of these (eg. \"Welcome\") will display a sub-page with more information."
                    +"\nThe items on the sub-page list are initially in bold text, and will turn to plain text when you have viewed the details for that item"
                    +"\nTo view the detailed text for an item just touch the relevant line of text and a popup dialog will appear with more detailed text about that item."
                    +"\nOn this popup dialog, you can click buttons to:\n(a) \"Close\" the dialog,\n(b) \"Mark\" or \"UnMark\" (which will show that item in blue background on the list, so you can mark item to read it again later or go to that event).\n(c) \"Next\" button to display the next item in the list."
                    +"\n\nFrom a subpage list, to return to the main \"SM16 Contents\" page, either press your phone’s \"Back\" button (usually at bottom left of the phone), or touch the back arrow at the top-left of the app."
                    +"\n\nThe \"Inbox\" item will contain notification messages, eg. programme or venue changes. To be able to receive these notifications you need a phone with Android version 2.3 or later, a working Play Store app (that you normally use to install apps), and a mobile data or WiFi connection."
                    +"\n\nSM16 App version: 0.6.23, 23-June-2016",
                    ""
                    // + "and \"Forward arrow\" icons in the menu bar at top right can be used to move between the pages."
                    // +"\n\nThe \"Back arrow\", and \"Forward arrow\" icons in the menu bar at top right can be used to move between the pages."
                    // +"\nOr you can select page from the drop-down menu by pressing the three vertical dots at the top-right"
                    // +"\n\nIf a line in the list ends with \"...\" then tapping that line will display more details"
            },
            {"1.03", "Activities",   "SALT Factory Sports\nFeeling energetic? You are in for a real treat with our activities this year!"
                    + "\nWe always like a little competitive spirit and as usual, we have the annual 5 a-side football competition; but this year we have added in, Tug-of-War, Ultimate Frisbee, Dodgeball and Tag Rugby."
                    + "\nWe’ll also have the second ever Summer Madness, \"It’s a Knockout\" competition."
                    + "\nBack by popular demand is the sailing and canoeing in the harbour."
                    + "\nIn the Wigwam, where there will also be giant garden games to give you an easy excuse to act like a child - again!",
                    String.valueOf(R.drawable.activities_130)
            },
            {"1.04", "A Typical Day of Madness",   "If you find yourself asking the question, ‘What does a day in the life of Summer Madness’ look like well here’s the answer…", ""},
            {"1.05", "8am",   "Emerge from your tent well rested and ready for the day. While you make use of the hot showers available in sub camp your group leader will prepare a nutritious breakfast to help fuel your day (If you follow your nose though you might make your way to the Christian Aid tent and treat yourself to a bacon buttie).", ""},
            {"1.06", "9:45am",   "Head to the Big Top with your group for the morning session starting with worship at 10am. This is followed by a mainstage talk from one of our guest speakers with the option of prayer ministry afterwards. If Big Top isn’t for you then head to the YFC venue for a more informal hang out space.", ""},
            {"1.07", "12:30pm",   "After the morning session you can check out the exhibition area and chat to our mission and partner agencies from across Ireland and the world. This is open all afternoon until the evening session as well if you miss them now.", ""},
            {"1.08", "1pm",   "It’s important to fuel up again before a busy afternoon of seminars and activities. You can either do this over your leaders mini-stove back in the sub camp or make use of one of our mobile food vendors. Either way, this is also an excellent time to talk with your group about the morning session and what you felt God was saying to you through it (PS: our food vendors are lovely folk who are open to group discounts if you book in advance).", ""},
            {"1.09", "2-6pm",   "The afternoon is yours to do with as you please. We have over 100 hours of seminar and activities on offer. Seminars to pick from include Preparing for Uni, Dance Workshops, Mental Health, Mission Opportunities, Peace and Reconciliation and so much more. And we have a wealth of activities to choose from including canoeing, sailing, football, dodgeball, slip ‘n’ slide and ultimate Frisbee. And if you’re just looking somewhere to chill there’s a couple of venues with a coffee and couch combo. At some point over the festival you will have to make sure you check out the hidden gem of Glenarm that is the Walled Garden.", ""},
            {"1.10", "6pm",   "As the afternoon fades away gather your group back together for dinner and hear what everyone got up to in the afternoon. Don’t worry if you missed a seminar or two – they’re all recorded and available to buy at the end of the conference for £10.", ""},
            {"1.11", "6:45pm",   "Head back to the Big Top or YFC venue for our evening session starting at 7pm.", ""},
            {"1.12", "9pm",   "As the Big Top empties our evening venues fill up. Here, you can enjoy a variety of live music or grab a coffee and a chat with your mates.", ""},
            {"1.13", "11:30pm",   "The venues go to bed for the night and so do you! Because it all starts again tomorrow morning bright and early. Our roving security team stay up during the night so give them a smile and a hug when you see them in the morning.", ""},


             // 2: Information & Contacts:
            {"2", "Rules & Information", "red", ""},
            // {"2.01", "First Aid",  "The first aid team can be contacted at .....", ""},
            // {"2.02", "Fire",   "In case of fire contact .......", ""},
            {"2.01", "Ground Rules", "1. Please show care and consideration for everyone on-site and for the site itself."
                    +"\n2. Smoking is not allowed anywhere on-site."
                    +"\n3. Alcohol must not be brought into or consumed on-site." +"\n4. No-one who is intoxicated will be permitted to either enter or remain on the site."
                    +"\n5. Wristbands or passes must be worn at all times to obtain entrance to all events."
                    +"\n6. No mixed sleeping (unless married)."
                    +"\n7. Tents must be at least 3 metres apart and should not be pitched without permission from the sub-camp leader."
                    +"\n8. Do not cook inside tents other than the designated cook tents."
                    +"\n9. No camp fires or disposable barbeques to be used on the grass."
                    +"\n10. No unauthorised vehicles allowed in the festival village area."
                    +"\n11. Valuables left in tents or cars are left entirely at the owner’s risk."
                    +"\n12. Litter must not be left around the site as there are plenty of bins available.  Use them!"
                    +"\n13. No pets to be kept on-site.  This is a festival run by humans for humans. Pets are not humans.",
                    ""},
            {"2.02", "Leaders’ Responsibilities",   "Those who are identified on bookings as leaders are responsible for their group. Leaders should not allow campers under their care to go off-site without their permission or without a specific time at which to report back. Leaders should not go off-site without leaving some other adult responsible for their group and should inform the sub-camp leader of this change. In the case of an emergency, we need to be able to contact the leader as soon as possible.  Your group is your responsibility!", ""},
            //{"2.03", "For youth leaders",  "See the Summer madness website for information: http://www.summermadness.co.uk/festival/project/leaders-info/", ""},
            {"2.03", "Emergencies",   "In the case of an emergency, please contact your sub-camp leader or the campsite office. Medical help is available 24 hours a day. If you need medical help just ask at the St. John Ambulance area or any member of staff.", ""},
            {"2.04", "Quiet Please",   "PLEASE be quiet at night. If you want to stay up late, please respect those who are trying to sleep. Noise carries across the campsite at night. A strict quiet curfew will be enforced in the camping area from 01:00 onwards.", ""},
            {"2.05", "Event Crew",   "Our Event Crew work long hours to make your festival experience trouble-free and enjoyable as possible.  They have volunteered their time for you, so why not give them a smile (or a couple of your sweets) to let them know they’re appreciated?", ""},
            {"2.06", "Access to the Big Top",   "Access to the Big Top is solely available via the Tearfund Café.", ""},
            {"2.07", "Lost Wristbands",   "If you lose your wristband the cost of a replacement is £5.00. These will only be replaced if verified by your leader (in person) and if ID is presented at the Admin Tent.", ""},
            {"2.08", "Boundary", "Crossing into any area demarcated by red and white tape is forbidden (this will constitute trespassing, and is punishable by law).", ""},
            {"2.09", "Avoid sectarian propaganda & proselytizing",   "Summer Madness wishes to make it clear that it does not favour sectarian propaganda or proselytizing within the Christian fellowship and anyone involved in these practices will be escorted off-site. This means that any group or individual which uses the SM Festival and its facilities for such purposes does so against the spirit of the event and could face a ban from future events.", ""},
            {"2.10", "Consequences ",   "Summer Madness reserves the right to cancel any booking (be it that of any individual or group) that the organisers deem necessary and escort all concerned parties off the premises if these ground rules are not observed.", ""},
            {"2.11", "The Larder - Don’t Throw It Away!",   "Before you leave Summer Madness put your unopened food in The Larder van in the sub-camp, and it will make its way to people who could really use it."
                    +"\nThe Larder is a food bank based in St Christopher’s, in Inner East Belfast."
                    +"\nFood is donated by churches, community groups, businesses and individuals and is used to help many families and individuals at times of crisis and emergency.  The summer months can be particularly difﬁcult ﬁnancially when children are not getting school meals. The Larder has provided food for over 6000 people in three years. This ministry is part of growing a new community of faith called Boring Wells."
                    +"\nIf you would like to be a supporter of the food bank or the wider ministry please visit: http://www.BoringWells.net", ""},
// Optional I added from SM website:
            {"2.12", "For parents",   "Summer Madness is a conference aimed at young people, as such everyone under 18 needs to be accompanied by a leader. It is the leader who takes direct responsibility for the young person, however, we ensure the environment is fun, exciting and safe for all involved. We have a large volunteer team of over 200 people serving in different areas including Prayer Ministry, Welcome Team and Security ensuring all requirements are met. You may find answers to some of your questions in the leaders downloads above, however don’t hesitate to get in touch with us via the contact details below"
                    +"\nEmail: office@summermadness.co.uk"
                    +"\nPhone: 02890 673 379"
                    +"\nWeb: http://www.summermadness.co.uk/",
                    ""},


            // 3. Inbox: // Should really convert to an new ArrayList<String[]>() so can extend it
            {inboxChapter, "Inbox",   "red", ""},
            {inboxChapter+".01", "Your notifications inbox",   "Updates or changes to the Summer Madness programme will appear below.", ""},


            // 4: Speakers & Venues:
            {"4", "Speakers & Venues", "red", ""},
            {"4.01", "Bluetree - worship",   "@bluetreeband\nComing from Belfast, Bluetree have been leading worship around the world since 2005 and are passionate about worship and justice. They are committed to pouring everything into building up the church for the glory of God and we’re delighted to be partnering with them at this year’s festival.",
                    String.valueOf(R.drawable.bluetree_130)},
            {"4.02", "Stephen Mayes & Band - worship",   "@stephen7m\nStephen is married to Abby and lives in Belfast. He is a worship leader with New Wine Ireland and this August will be joining Re:Hope Church to launch a new campus in the heart of Belfast City Centre. Stephen and his band desire to see people connect to the Father’s heart in worship by facilitating an atmosphere that encourages joy, intimacy and freedom to fully embrace the presence of the living God.",
                    String.valueOf(R.drawable.stephen_mayes_130)},
            {"4.03", "Rachel Hughes - speaker",   "@rachelemhughes\nRachel Hughes is married to Tim and they have 4 young children. They have recently moved from London (Holy Trinity Brompton/Alpha) where Rachel was involved in leading women’s ministry and teaching. Tim & Rachel have just moved to Birmingham and planted a new church there (St. Luke’s Gas Street).",
                    String.valueOf(R.drawable.rachel_hughes_130)},
            {"4.04", "Matt Summerfield - speaker",   "@livelife123org\nMatt Summerfield balances his time between being the Chief Executive of Urban Saints and the Senior Pastor of Hitchin Christian Centre. He is the founder of the lifelive123.org – a new movement of people committed to intentional, accountable disciple-making relationships. He loves Haagen Daaz Belgian Chocolate ice cream, meat feast pizzas and great movies.",
                    String.valueOf(R.drawable.matt_summerfield_130)},
            {"4.05", "Adrian McCartney - speaker",   "@adrianmccartney\nAdrian is the leader of Boring Wells, a family of missional communities in Belfast. Together with his wife Janice and their three children, he has been pioneering new ways of church for over 20 years. Despite being a man of deep thought and unconventional wisdom, he also has a stunning left foot on the 5-a-side football pitch.",
                    ""},
            {"4.06", "Stu Bothwell - speaker",   "@stubothwell\nStuart is 28 and married to the lovely Emma. Together, they live in East Belfast and are passionate about seeking the flourishing of the city. Stuart has recently joined the team at Summer Madness and CATALYST. There’s little Stuart loves more than sharing meals with friends both old and new. He is constantly searching for new music to wrap his ears around.",
                    ""},

            {"4.07", "The Big Top",   "We love gathering together in the Big Top. There may be well over a 1000 people in it, but it offers such an intimate worship space where God encounters us uniquely with His love and grace. We keep the Big Top for our worship gatherings so there’s more time and space to engage with God without being rushed away. Access to the Big Top is available via the Tearfund Venue only.", ""},
            // from SM website:  "We love The Big Top and it offers such an intimate Worship space. There may be over 2000 people in it but often it feels like God puts his finger right on you. There are deliberately no arts programme in the Big Top, so there’s more time and freedom to engage with God without being rushed away or distracted by sound checks."

            {"4.08", "Tearfund Cafe",   "Tearfund is a Christian international aid and development agency working globally to end poverty and injustice, and to restore dignity and hope in some of the world’s poorest communities. The Tearfund Cafe is located in the first courtyard and is a great place to hang out, learn more about their work and buy hot drinks and baked goods from Belfast-based coffee shop Cafe Smart."
                    +"\n\nEXHIBITORS: Come to browse and discover opportunities and ways to engage with various agencies and charities. During Main Stage worship, there will be a live video link from the Big Top shown in the exhibitors area."
                    +"\n\nPHONE CHARGING: This year, give your phone what it needs in the Tearfund café. £1 for 1 hour"
                    +"\n\nTHIS IS SELENA: Selena is fighting for survival. She lives in one of the poorest regions of Malawi, a country being ravaged by lifethreatening hunger. Visit the Tearfund Café to hear her story and find out how your youth group can make a difference to families like hers.",
                    ""},
            // was from SM website:  "Tearfund is a Christian international aid and development agency working globally to end poverty and injustice, and to restore dignity and hope in some of the world’s poorest communities. The Tearfund Café is located in the first courtyard and is a great place to hang out, learn more about their work and buy hot drinks and baked goods from Belfast-based coffee shop and social enterprise, Common Grounds.",

            {"4.09", "DNA Tent",   "DNA Tent is back again this year. The venue is a living exploration of what Ireland is, what we are called to be, and how God wants us to heal. It is a snapshot of God’s redemptive purpose for this island. Along with our small coffee pod will be a venue that is staffed by a team of committed workers from Urban Saints. We’re here to chat, pray and hangout. Come and see what we’re doing all over Ireland. Come and decorate our mural of hope and use it to pray for the land. Come and reflect on our call to be a light to the nations, Sign up for personal prayer from our team who will pray for your original design. What is your spiritual DNA from conception? Use your creativity!", ""},
            {"4.10", "24/5 Prayer Room",   "The prayer room is a creative and interactive space for you to come and spend time chatting with God through words, art, music, activity and silence. Our desire is that the prayer room will be a place where you meet with God, where you can process what God is saying to you throughout the festival and pray big prayers for your family, friends, church and the nation!", ""},
            {"4.11", "The Campus",   "....................", ""},
            {"4.12", "Seminar One",   "Located near entrance gate ....", ""},
            {"4.13", "Seminar Two",   "Located near entrance gate ....", ""},
            {"4.14", "Seminar Three",   "Located near entrance gate ....", ""},
            {"4.15", "CIYD Connect",   "Imagine a space of calm among the Madness. If you are a youth leader, youth worker, committed in your role among young people and you are craving a quiet space to escape the Madness, feel free to drop in, flop into a comfy sofa, enjoy FREE coffee and freshly baked goods. Whilst all goodies are free any donations made will go towards the Twin a Tent campaign for refugee crisis. CIYD welcomes you and your team to enjoy the comfort and calm of this little space.", ""},
            {"4.16", "YFC Drop-In",   "Every afternoon and evening you will be able to pop into the venue and enjoy a game of pool or table tennis, have a go on the X-box or PS4; or just hang out and have a cuppa with one of the YFC Team. Throughout the day, there will also be various competitions and events for those of you who are up for the challenge and in the evening you can spend some time relaxing on one of the sofa’s and enjoy some live music from various local artists. Cage football will be located outside the YFC Drop In.", ""},
            // {"4.17", "The Woodland Cafe",   "The Woodland Cafe isn’t quite in the Woodland anymore, but hey! We still like the name! The good news is that we are right beside the food vendors, so if you are looking some shelter from the blistering sunshine or the odd light drizzle, this is the place for you. Run by the Methodist, Church of Ireland and Presbyterian Chaplaincies at Queen’s University, there’s a great selection of drinks, snacks, milkshakes and ice cream and plenty of folk around to ensure you’re well looked after. Somewhere to chill or take timeout from the busy festival.", ""},

            // 5: Friday
            {"5", "Friday", "green", ""},
            {"5.01", "7pm -Mainstage Worship -Big Top",   "Speaker: Stu Bothwell\nWorship: Bluetree\n\nDoors of Big Top open at 6.30pm\nLive-streamed into Mainstage Overflow in Tearfund Cafe\n\nEnds: 9pm", ""},
            {"5.02", "9:15pm -Tom McConnell -DNA Tent",   "Ends: 10:30pm", ""},
            {"5.03", "9:15pm -DJ Billy Fyffe -The Campus",  "Ends: 10:30pm", ""},
            {"5.04", "11pm -Late Night Worship -Seminar One",   "Ends: 11:45pm", ""}, // was: Jamie Neish


            // 6: Saturday
            {"6", "Saturday", "green", ""},
            {"6.01", "8am -Morning Bible study -The Campus",   "Simon Lennox\nEnds: 8:45am", ""},
            {"6.02", "8:45am -Group Time",   "Journal on page 55\n\nEnds: 9:45am", ""},
            {"6.03", "10am -Mainstage Worship -Big Top (doors open 9.30am)",   "Speaker: Matt Summerfield\nWorship: Bluetree\n\nDoors of Big Top open at 9.30am\nLive-streamed into Mainstage Overflow in Tearfund Cafe\n\nEnds: 12pm", ""},

            {"6.04", "12pm -Building Relationships that Last -Seminar Two",   "Matt Bird gives you the inside track on how to manage relationships in every sphere, personal, professional and church based. Don’t miss these great insights that will enhance your understanding and skills in building networks around you that sustain and nourish you in every part of your life."
                    +"\n\nEnds: 1pm", ""},
            {"6.05", "12pm -Song Writing Workshop -The Campus",   "Daniel Duke & Tom McConnell\n\nEnds: 1pm", ""},
            {"6.06", "1pm -Tom McConnell -Outdoor Stage",   "Ends: 2pm", ""},
            {"6.07", "1pm -Sullivan & Gold -The Campus",   "Ends: 2pm", ""},

            {"6.08", "2pm -Spiritual Disciplines: INWARD -CIYD Connect",   "CIYD Team\nPart One. Join the CIYD team and young people as they share TED-style talks on how we can get UP CLOSE + PERSONAL with God through developing Spiritual Disciplines. In Part One, they’ll be exploring disciplines that engage the heart.\n\nEnds: 3pm", ""},
            {"6.09", "2pm -Islam and Isis: Your Questions answered -Seminar Two",   "Jim Stewart (EA) and Abdul Azim\nDo you understand what Muslims really believe, why Isis exists or the reasons for much of the conflict between Islam and Chrisitianity? Join Jim Stewart (Evangelical Alliance) and Abdul Azim from Cardiff who have pioneered a new approach to interfaith relationships to discuss openly some of the challenges and misperceptions that abound in modern Britian and Europe.\n\nEnds: 3pm", ""},
            {"6.10", "2pm -Soul Sista: Secret Royals -Seminar One" ,   "Jill Boyd.\nGod is calling us to wake up and understand exactly who we are. The challenge is to live higher, like the royal girls we truly are. This kingdom is one of love, and it’s supposed to have an impact in our lives and the people around us. Let’s not simply fit into the current culture and its ways. We are called to so much more - but what does that look like?\n\nEnds: 3pm", ""},
            {"6.11", "2pm -Making Disciples Who Make Disciples -DNA Tent",   "Matt Summerfield & Wilson Beare, Urban Saints\nPractical tips on the who, how and what of disciple-making? How to partner with God in the greatest joy of all - seeing someone’s life transformed!\n\nEnds: 3pm", ""},
            {"6.12", "2pm -Mad Men: Falling in Love or Lust -Seminar Three",   "Niall McNally\nNiall speaks to the social awkwardness of our teenage years. How to navigate hormones, the sexualisation of culture and the issues of the heart. Niall’s honesty is refreshing and disarming, all peppered with a good dose of humour to help us not take ourselves too seriously.\n\nEnds: 3pm", ""},

            {"6.13", "3:15pm -Leadership: Rhythms & Rest -CIYD Connect",   "Stu Bothwell\nIt’s been said that busyness is the enemy of spirituality. For us as leaders, weighed down by our responsibilities, dreams and to-do-lists, this statement can offend us. However, in our busy and distracted age, it’s important for us to develop a healthy rhythm of life. Join Stu as he explores these issues.\n\nEnds: 4.15pm", ""},
            {"6.14", "3:15pm -Global Outreach Day: Be a part of it -The Campus",   "Jasper Rutherford\nWhat if 100,000 people across Ireland shared their faith in Jesus together on one day? On 27th May 2017 that is going to happen. Come and hear how you and your Church can be involved in Global Outreach Day.\n\nEnds: 4:15pm", ""},
            {"6.15", "3:15pm -But What can I Do? -Seminar Two",   "Hannah Douglas, Tearfund\nAs we watch our TV screens and follow the news, we are bombarded daily with the injustice there is in our world today. As young people question our response to hunger, poverty, refugees and disasters, we are required to wrestle with them in their questioning. Hannah will be wrestling with some of these issues.\n\nEnds: 4:15pm", ""},
            {"6.16", "3:15pm -The Digital you -Seminar One",   "Niall McNally\nWith Snapchat, Facebook, Twitter & Instagram playing such a massive role in our lives today, in his seminar Niall will be shining some light on the bits of social media that we should double tap and the parts that we should double check. Expect emoticons.\n\nEnds: 4:15pm", ""},
            {"6.17", "3:15pm -Decommissioning Mindsets -DNA Tent",   "James Wilson & Dr. Gladys Ganiel\nEx-combatants from the British Army and Republican/Loyalist paramilitary organisations will discuss the impact of cultures of militarism on their lives. They will provide alternative narratives that challenge the glorification of violence in society and churches.\n\nEnds: 4:15pm", ""},
            {"6.18", "3:15pm -Friendship: I’ll be there for you -Seminar Three",   "Pete Waugh\nThe Book of Proverbs tells us that you won’t make it in life unless you are good at choosing, forging and keeping terrific friendships. In a world where we are increasingly connected with others this seminar will question how meaningful those connections are and discover what counts as true friendship.\n\nEnds: 4:15pm", ""},

            {"6.19", "4:30pm -Preparing for University -The Campus",   "Barry Forde & Guests\nQueens University chaplain Barry Forde will introduce you to some of the basics of University life and give you a few tools to help navigate your way through in the most productive, satisfying and stimulating way possible!\n\nEnds: 5:30pm", ""},
            {"6.20", "4:30pm -Responding to the Refugee Crisis -Seminar Two",   "MAP\nHow can we reach out and share the love of Jesus with the hundreds of thousands of refugees fleeing trouble, war and persecution? MAP share some stories of their experiences.\n\nEnds: 5:30pm", ""},
            {"6.21", "4:30pm -Does God Care What Nationality You Are? -Seminar One",   "Nicola Mallon (SDLP), Gavin Robinson (DUP), Chris Lyttle (Alliance), John Kyle (PUP)\nA panel of local political leaders discuss the relevance of nationality within a Christian worldview and modern European society.\n\nEnds: 5:30pm", ""},
/////*            {"6.22", "4:30pm -Dance Workshop -DNA Tent",   "Vibe Academy\n\nEnds: 5:30pm", ""},
            {"6.23", "4:30pm -The Curse of Quiet Time: When Tools become Rules -Seminar Three",   "David Dunlop\nHow easy is it to tell the difference between being a slave to a regime and building helpful habits. David Dunlop shares his personal take on some of the most helpful ways of nurturing your soul and growing in intimacy with God.\n\nEnds: 5:30pm", ""},

            {"6.24", "7pm -Mainstage Worship -Big Top (doors open 6.30pm)",   "Speaker: Matt Summerfield\nWorship: Bluetree\n\nDoors of Big Top open at 6.30pm\n\nLive-streamed into Mainstage Overflow in Tearfund Cafe\n\nEnds: 9pm", ""},
            {"6.25", "7pm -Alternative to Mainstage -YFC Drop In",   "Ends: 9pm", ""},
            {"6.26", "9:15pm -Brash Isaac -The Campus",   "Ends: 10pm", ""},
            {"6.27", "9:15pm -PTYK & Billy Fyffe Alphabet Disco - DNA Tent",   "\n\nEnds: 11pm", ""},
            {"6.28", "10:15pm -Daniel Duke -The Campus",   "Ends: 11:15pm", ""},
            {"6.29", "11pm -Late Night Worship -Siminar One",   "Ends: 11:45pm", ""},


             // 7: Sunday:
            {"7", "Sunday", "green", ""},
            {"7.01", "8am -Morning Bible study -The Campus",   "Simon Lennox\nEnds: 8:45am", ""},
            {"7.02", "8:45am -Group Time -Journal on page 55",   "\n\nEnds: 9:45am", ""},
            {"7.03", "10am -Mainstage Worship -Big Top (doors open 9.30am)",    "Speaker: Adrian McCartney\nWorship: Bluetree\n\nDoors of Big Top open at 9.30am\nLive-streamed into Mainstage Overflow in Tearfund Cafe\n\nEnds: 12pm", ""},
            {"7.04", "12pm -Authentic Intimacy -Seminar Two",    "Worship Central\nThe team from Worship Central Ireland & N.Ireland will be exploring the challenge of sustaining intimacy with God while being committed to our involvement in worship ministry.\n\nEnds: 1pm", ""},
            {"7.05", "1pm -Wildfire -The Campus",   "Ends: 2pm", ""},
            {"7.06", "1pm -Daniel Duke -Outdoor Stage",   "Ends: 2pm", ""},

            {"7.07", "2pm -Spiritual Disciplines: OUTWARD -CIYD Connect",   "CIYD Team\nPart Two. Join the CIYD team and young people as they share TED-style talks on how we can get UP CLOSE + PERSONAL with God through developing Spiritual Disciplines. In Part Two, they’ll be exploring disciplines that lead us into service and mission.\n\nEnds: 3pm", ""},
            // {"7.08", "2pm -*BLANK in programme* -The Campus",   "Ends: 3pm", ""},
            {"7.08", "2pm -UnLearn Prayer -Seminar Two",   "Matt Summerfield\nJust when you thought you understood what prayer was all about, Jesus invites us to think again about prayer in his most famous sermon of all. Join us for this session where we’ll explore what Jesus has to say about the true privilege, purpose, persistence and practices of life-giving prayer.\n\nEnds: 3pm", ""},
            {"7.09", "2pm -Soul Sista: My Royal Subjects -Seminar One",   "Jill Boyd\nThe kingdom we are part of has two basic principles - LOVE GOD & LOVE PEOPLE. No relationship we engage in should ever be unaffected by God’s way and His love. In a world that screams chaos and celebrates dysfunction - God has a better way. It usually doesn’t take that long in a room full of girls that the boy, love and relationship chat rears its head. Discover how a Kingdom Royal addresses these issues and more head on.\n\nEnds: 3pm", ""},
            {"7.10", "2pm -Spirit Radio Workshop -DNA Tent",   "Ends: 3pm", ""},
            {"7.11", "2pm -Mad Men: Warm bodies -Seminar Three",   "Niall McNally\nHow to save your marriage before you meet your Spouse, not just a Porn free life, but a vision of love that champions and ushers in the kingdom of God. From a Fatherless generation to men who dare to love sex more than the world says it does. A Theology for your bodies & souls that prepares the Bride of Christ.\n\nEnds: 3pm", ""},

            {"7.12", "3:15pm -Sensitive Conversations : When It’s Hard to Talk About What Really Matters -CIYD Connect",   "Donchadh Greene\nWhat is it like to grow up in church in NI as a gay Christian and how do church leaders and youth workers deal with the pastoral and theological issues involved? Donnchadh Green shares some of his experiences with Rev. Barry Forde as they explore these highly charged and often contentious areas of church life and ministry. The seminar is aimed at youth leaders and those involved in the practical and pastoral outworking of a Biblical approach to sexuality in the midst of much public debate and scrutiny.\n\nEnds: 4.15pm", ""},
            {"7.13", "3:15pm -Documenting Disaster -Seminar Two",   "David Cavan, Tearfund\nWe see photos and watch films of poverty and to be honest it can all get a bit overwhelming. Behind all the images, still ever moving, there are stories. David has been a professional photographer for 7 years and has travelled and documented stories from around the world. Come along and hear about some of those stories and how organisations like Tearfund are doing everything in their power to facilitate a seismic change in those individuals around the world who are behind the images.\n\nEnds: 4.15pm", ""},
            {"7.14", "3:15pm -Tails YOU Lose -Seminar One",   "Justyn Rees Larcombe\nJustyn is the son of the writer and speaker Jennifer Rees Larcombe and grandson of the evangelist Tom Rees. After a highly successful career in the British Army Justyn Rees Larcombe had an equally glittering and well-rewarded career in the City. His life was ruined by gambling but he shares here the story of God’s grace in the situation and passes on the valuable learning and insights about addiction of all sorts.\n\nEnds: 4.15pm", ""},
            {"7.15", "3:15pm -Jesus Followers -DNA Tent",   "Matt Summerfield & Wilson Beare, Urban Saints\nSo you’re a Christian. Great news! But what does that mean? Join us for this seminar where we’ll explore the BEING, DOING and KNOWING of being a Jesus follower!\n\nEnds: 4.15pm", ""},
            {"7.16", "3:15pm -The Cost Of Growing Up -The Campus",   "CAP\n“How can I manage money when there’s pizza in the world?” A good question, although it is do-able (God provides us with everything we need, even if we don’t have the mula!). Learn how to make every penny count and trust us, they do!\n\nEnds: 4.15pm", ""},

            {"7.17", "4:30pm -More Than a Bad Day -Seminar Two",   "The Big House\nWhat is depression? Is it just having a bad day? Is it crying a lot? How can a Christian be depressed? In this seminar we will look at what the Bible has to say and hear a personal story as we explore what it means to be depressed, why someone might feel that way, and ways we can help a person going through it.\n\nEnds: 5:30pm", ""}, // David Cavan, Tearfund
            {"7.18", "4:30pm -Up Close & Personal with... -Seminar One",   "Michelle Scott, Rachel Hughes & Matt Summerfield\nThis is your chance to get UP CLOSE + PERSONAL with some of our mainstage speakers and great local leaders! Join Rachel, Matt and Michelle as they share personal stories of how they have encountered the UP CLOSE + PERSONAL God in the past and how they experience Him even in the busyness of their everyday lives.\n\nEnds: 5:30pm", ""},
            {"7.19", "4:30pm -Dance Workshop -DNA Tent",   "Vibe Academy\n\nEnds: 5.30pm", ""},
            {"7.20", "4.30pm -Evangelism: Anyone Can Do It! -Seminar Three",   "Phil Timson\nEvangelism is a ‘no-brainer!’ It’s our responsibility to ‘Go and make disciples’ (Matt 20:20). This seminar will look at our call to evangelism and how we can best reach our mates for Jesus. Through exploring some key principles, be inspired and equipped to make sharing your faith, a natural part of everyday life.\n\nEnds: 5:30pm", ""},

            {"7.21", "7pm -Mainstage Worship -Big Top (doors open 6.30pm)",   "Speaker: Rachel Hughes\nWorship: Stephen Mayes\n\nDoors of Big Top open at 6.30pm\n\nLive-streamed into Mainstage Overflow in Tearfund Cafe\n\nEnds: 9pm", ""},
            {"7.22", "7pm -Alternative to Mainstage -YFC Drop In",   "Ends: 9pm", ""},

            {"7.23", "9:15pm -Chris Wilson -The Campus",   "Ends: 10pm", ""},
            {"7.24", "9:15pm -Mark Ferguson -DNA Tent",   "Ends: 10pm", ""},
            {"7.25", "10:15pm -Hillspeak -DNA Tent",   "Ends: 11pm", ""},
            {"7.26", "11pm -Late Night Worship -Siminar One",   "Ends: 11:45pm", ""},


            // 8: Monday:
            {"8", "Monday", "green", ""},
            {"8.01", "8am -Morning Bible study -The Campus",   "Simon Lennox\nEnds: 8:45am", ""},
            {"8.02", "8:45am -Group Time -Journal on page 55",   "\n\nEnds: 9:45am", ""},
            {"8.03", "10am -Mainstage Worship -Big Top (doors open 9.30am)",   "Speaker: Adrian McCartney\nWorship: Stephen Mayes\n\nDoors of Big Top open at 9.30am\nLive-streamed into Mainstage Overflow in Tearfund Cafe\n\nEnds: 12pm", ""},
            {"8.04", "10am -Alternative to Mainstage -YFC Drop In",   "Ends: 12pm", ""},
            {"8.05", "1pm -Beulah Kim -The Campus",   "Ends: 2pm", ""},
            {"8.06", "1pm -Jonny Solari -Outdoor Stage",   "Ends: 2pm", ""},
            //{"8.07", "1pm -Jamie Neish -DNA Tent",   "Ends: 2pm", ""},
            {"8.07", "1:15pm -Illustrated Faith -DNA Tent",   "Ends: 2pm", ""},

            {"8.08", "2pm -Spiritual Disciplines: CORPORATE -CIYD Connect",   "CIYD Team\nPart Three. Join the CIYD team and young people as they share TED-style talks on how we can get UP CLOSE + PERSONAL with God through developing Spiritual Disciplines. In Part Three, they’ll be exploring disciplines that we can engage in together.\n\nEnds: 3pm", ""},
            {"8.09", "2pm -When I Pray What Does God Do? -The Campus",   "Prof David Wilkinson\nScientist and theologian David Wilkinson shares his own struggles with the question of how God answers prayer in this Skype seminar. Science does not rule out God acting in the universe in surprising ways; the Bible shows a God who acts in the world in response to people’s prayers. Yet there is always a mystery about the nature and outcome of prayer, not least in the experience of unanswered prayer.\n\nEnds: 3pm", ""},
            {"8.10", "2pm -If God Exists, Why Doesn’t He Show Himself More Clearly? -Seminar Two",   "Dr David Glass\nWhat do we mean when we say ‘there’s not enough evidence’ to believe? Does what we know of science, the world, our feelings, the universe of ideas and life have room for the God of the Bible? Dr David Glass helps us navigate through some of these big issues and examine what we know and don’t know when talking about God - and ‘evidence’.\n\nEnds: 3pm", ""},
            {"8.11", "2pm -Modern Romance: The Dating games -Seminar One",   "Stuart Bothwell\nDating should be fun. Yet in reality, it can feel like a battleground. In the follow up seminar to Soul Sis & Mad Men, join Stu as he explores the good and bad of getting together and how we can survive the arena of dating.\n\nEnds: 3pm", ""},

            {"8.12", "3:15pm -Leading Yourself Before Leading Others -CIYD Connect",   "Rachel Hughes\nAs we serve others in leadership, we can often neglect ourselves and our relationship with Christ. We must prioritise an UP CLOSE + PERSONAL life with Christ, which enables us to lead others well. Join Rachel as she unpacks how we can lead ourselves before leading others.\n\nEnds: 4.15pm", ""},
            {"8.13", "3:15pm -Guidance: Hearing God Speak For Yourself -The Campus",   "Barry Forde\nSometimes we wish that God would just use a (very large) whiteboard and spell things out in a rather unmistakable way but that isn’t always the case for most of us. So Barry Forde will ‘guide’ us through the ways in which we might become more attentive to God’s prompting and examine how that could impact our decision making processes – especially the big ones!\n\nEnds: 4.15pm", ""},
            {"8.14", "3:15pm -The Church Around the Corner -Seminar Two",   "Tom Stewart, Cinnamon Network\nHow well does your church reach out to the local community sharing God’s love in practical ways? YOU have the chance to receive £2000 towards your own efforts to do just that. This year we are in a VERY fortunate position to be able to receive 10 such grants for Summer Madness groups. Come along and speak to the experts about how to get started and develop a successful project.\n\nEnds: 4.15pm", ""},
            {"8.15", "3:15pm -Real Families -Seminar One",   "The Big House\nThere is no such thing as a perfect family, just real families. The reality of family life is this: it can be good, difficult, fun, and complicated but it’s never perfect! This seminar will explore what God has for us within our experience of family drawing on Biblical examples of imperfect families.\n\nEnds: 4.15pm", ""},
            {"8.16", "3:15pm -Five Ways to shape Your Culture -DNA Tent",   "Emma Worrall, Open Doors\nFed up of being shaped by a culturethat says we’ll never be good enough, fit enough, rich enough or successful enough? How can we change it? How can we shape it to better reflect Jesus centred values of hope, forgiveness and love? Come and hear five suggestions, drawn from Christians living in places where following Jesus is outlawed, and where standing up for him can mean beatings, arrest and worse.\n\nEnds: 4.15pm", ""},
            {"8.17", "3:15pm -Walking Free From Drug Addiction -Seminar Three",   "John Edwards\nFor 20 years, John Edwards was a drug addict and alcholic. Yet he encountered the UP CLOSE + PERSONAL God and his life was transformed. Now free, clean and sober for 23 years, John shares his powerful story and exposes the danger of addiction.\n\nEnds: 4.15pm", ""},

            {"8.18", "4:30pm -Can We Talk?... Will You Listen? -The Campus",   "Sharon Hamill featuring John Alderdice, Emma Rothwell & Alain Emerson\nAre you keen to bring your questions regarding Christian faith in current culture to those in Christian leadership and discuss among your peers? Do you have a vision for the Church in the future? You are invited to a UNIQUE gathering where young people will be central to the conversation. Young people will lead and facilitate your questions, thoughts, opinions and ideas across a panel of young people and those in Church Leadership.\n\nEnds: 5:30pm", ""},
            {"8.19", "4:30pm -When Life Gets Difficult -Seminar Two",   "Up Close + Personal with Suffering in Society\nMAP\nThis seminar will look at a biblical view of the sanctity and value of life. It will explore challenges in society in how this biblical view is being eroded and challenged with various issues such as abortion and assisted dying. Together we will look at how to respond to these issues.\n\nEnds: 5:30pm", ""},

            {"8.20", "4.30pm -New Christians -Seminar Three",   "Following Jesus After Madness\nNeville Barnes\nThe Christian walk is supposed to be just that - a walk! Making a decision to follow Jesus is just the start. This seminar is to help you grow in your relationship with God when you get back home. It’s a must if you have come to faith at the festival and for youth workers if young people in your group have come to faith.\n\nEnds: 5:30pm", ""},
            {"8.21", "4:30pm -Opening Up The Bible -DNA Tent",   "Precept Ministries\nAre you a youth leader trying to encourage your young people to open their bibles? Precept Ministries work through some simple skills to help you with this. Their CSI style inductive Bible study will leave you with plenty of ideas for the year ahead.\n\nEnds: 5.30pm", ""},

            {"8.22", "7pm -Mainstage Worship -Big Top (doors open 6.30pm)", "Speaker: Rachel Hughes\nWorship: Stephen Mayes\n\nDoors of Big Top open at 6.30pm\n\nLive-streamed into Mainstage Overflow in Tearfund cafe\n\nEnds: 9pm", ""},
            {"8.23", "9:15pm -David Walker -The Campus",  "Ends: 10pm", ""},
            {"8.24", "9:15pm -PTYK UV Party -DNA Tent",   "Ends: 11pm", ""},
            {"8.25", "11pm -Late Night Worship -Siminar One",   "Ends: 11:45pm", ""},


            // 9: Tuesday & Afterwards (What Next):
            {"9", "Tuesday & What Next",   "red", ""},
            {"9.01", "10am -Mainstage Worship -Big Top (doors open 9.30am)", "Speaker: Rachel Hughes\nWorship: Stephen Mayes\nDoors of Big Top open at 9.30am\nEnds: 12pm", ""},
            {"9.02", "After Summer Madness 2016",   "Now that Summer Madness is over for 2016, what can I do now. Here are some ideas.", ""},
            {"9.03", "Total Recall",   "Get the Total Recall USB stick with audio recordings of all the Mainstage talks and Seminars ....", ""},
            {"9.04", "Your friends",   "Tell and encourage your friends ....", ""},
            {"9.05", "Your church",   "Get involved at your church....", ""},
            {"9.06", "Pray",   "Pray for ....", ""},
            {"9.07", "Study",   "Bible reading notes ....", ""},
            {"9.08", "Ignite",   "https://ignitecd.wordpress.com/", ""},
            {"9.09", "Give",   "Giving your time or/and resources ....", ""},
            {"9.10", "Supporting missions",   "Local and overseas ....", ""},
            {"9.11", "Volunteer for SM 2017",   "Volunteer to help run next year’s summer madness: http://www.summermadness.co.uk/festival/project/get-involved/", ""}

    };
}
