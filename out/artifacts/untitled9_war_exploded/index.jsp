<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">
<head>
    <meta charset="UTF-8">
    <title>Think simple - Home</title>
    <link rel="icon" href="images/favicon.gif" type="image/x-icon"/>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link type="text/css" href="css/css3.css" rel="stylesheet" />
    <script type="text/javascript" src=" https://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.pikachoose.js"></script>
    <script language="javascript">
        $(document).ready(
                function (){
                    $("#pikame").PikaChoose();
                });
    </script>



</head>
<body>

<!--start container-->
<div id="container">

    <!--start header-->

    <header>

        <!--start logo-->
        <a href="#" id="logo"><img src="images/logo.png" width="221" height="100" alt="logo"/></a>

        <!--end logo-->

        <!--start menu-->

        <nav>
            <ul>
                <li><a href="#" class="current">Home</a>

                </li>
                <li><a href="#">About us</a></li>
                <li><a href="#">Login</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>

            </ul>
        </nav>
        <!--end menu-->


        <!--end header-->
    </header>


    <!--start intro-->

    <div id="intro">

        <div class="group_bannner_right">
            <img src="images/picture.png" width="550" height="316"  alt="baner">
        </div>

        <header class="group_bannner_left">
            <hgroup>
                <h1>Simple.Think. </h1>
                <h2>“The little things are infinitely the most important.“
                </h2>
            </hgroup>
        </header>
    </div>
    <!--end intro-->



    <script type="text/javascript">
        function handleLoginRequest(xhr, status, args) {
            if(args.validationFailed || !args.loggedIn) {
                PF('dlg').jq.effect("shake", { times:5 }, 100);
            }
            else {
                PF('dlg').hide();
                $('#loginLink').fadeOut();
            }
        }
    </script>

    <!--start holder-->

    <div class="holder_content">

        <section class="group1">
            <h3>About us</h3>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>
            <a href=""><span class="read_more">Read more...</span></a>

        </section>



        <section class="group2">
            <h3>Services</h3>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>
            <a href=""><span class="read_more">Read more ...</span></a>

        </section>



        <section class="group3">
            <h3>News</h3>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>
            <a href=""><span class="read_more">Read more...</span></a>

        </section>


    </div>
    <!--end holder-->

    <!--start holder-->

    <div class="holder_content1">
        <section class="group4">
            <h3>Gallery</h3>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>
            <div class="pikachoose">
                <ul id="pikame" >
                    <li><a href="#"><img src="images/picture3.jpg" width="500" height="250"  alt="picture"/></a><span>“Simplicity is the nature of great souls.”</span></li>
                    <li><a href="#"><img src="images/picture2.jpg" width="500" height="250" alt="picture"/></a><span>“The little things are infinitely the most important. “ </span></li>
                    <li><a href="#"><img src="images/picture1.jpg" width="500" height="250" alt="picture"/></a><span>“Simplicity is the essence of happiness.”</span></li>
                </ul>
            </div>

        </section>



        <section class="group5">
            <h3>Testimonials</h3>
            <p><span class="purple">1)</span>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>
            <p><span class="purple">2)</span>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>
            <p><span class="purple">3)</span>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin.
                Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst. Nulla nonummy. Cras quis libero.</p>


        </section>


    </div>
    <!--end holder-->



</div>
<!--end container-->

<!--start footer-->
<footer>
    <div class="container">
        <div id="FooterTwo"> © 2011 Think simple </div>
        <div id="FooterTree"> Valid html5, design and code by <a href="http://www.marijazaric.com">marija zaric - creative simplicity</a>   </div>
    </div>
</footer>
<!--end footer-->
</body>
</html>