//Author: Timothy van der Graaff
package apps;

import configuration.Config;
import controllers.Request_CSS_Responsive_Design_Screens;
import controllers.Request_Footer_Content;
import controllers.Request_Website_Name;
import controllers.Request_Web_Page;
import controllers.Request_Website_Icon;
import controllers.Request_Website_Logo;
import controllers.Request_Website_Links;
import java.io.IOException;

import java.sql.Connection;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://www.timothysdigitalsolutions.com", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/web-page")
public class Web_Page {
    
    @RequestMapping(method = RequestMethod.POST)
    String home(
            @RequestParam(value = "url", defaultValue = "") String url,
            @RequestParam(value = "page", defaultValue = "") String page,
            @RequestParam(value = "page_preview", defaultValue = "") String page_preview,
            @RequestParam(value = "show_website", defaultValue = "") String show_website
    ) {
        
        Connection use_open_connection;
        
        try {
            
            use_open_connection = Config.openConnection();
            
            Request_CSS_Responsive_Design_Screens.show_website = String.valueOf(show_website);
            
            Request_Web_Page.show_website = String.valueOf(show_website);
            
            Request_Web_Page.url = String.valueOf(url);
            Request_Web_Page.page = String.valueOf(page);
            Request_Web_Page.page_preview = String.valueOf(page_preview);
            Request_Web_Page.show_website = String.valueOf(show_website);
            Request_Web_Page.use_connection = use_open_connection;
            
            Request_Website_Links.url = String.valueOf(url);
            Request_Website_Links.page = String.valueOf(page);
            Request_Website_Links.show_website = String.valueOf(show_website);
            
            Request_Website_Links.use_connection = use_open_connection;
            Request_CSS_Responsive_Design_Screens.use_connection = use_open_connection;
            Request_Website_Icon.use_connection = use_open_connection;
            Request_Website_Logo.use_connection = use_open_connection;
            Request_Website_Name.use_connection = use_open_connection;
            
            Request_Footer_Content.show_website = String.valueOf(show_website);

            //Search for web page
            Request_Web_Page.search_web_page();

            //Search for website links
            Request_Website_Links.search_website_link();

            //Search for footers
            Request_Footer_Content.use_connection = use_open_connection;
            Request_Footer_Content.search_footer_content_section();

            //Find website name
            Request_Web_Page.website_name = Request_Website_Name.request_website_name();
            
            return Request_Website_Icon.request_website_icon() + "\n" +
                    Request_CSS_Responsive_Design_Screens.request_css_responsive_design_screens() + "\n" +
                    Request_Web_Page.request_page_description() + "\n" +
                    Request_Web_Page.request_page_keywords() + "\n" +
                    Request_Web_Page.request_title() + "\n" +
                    "<script>document.body.style.backgroundColor = \"#FBDFCC\";</script>\n" +
                    "<style type=\"text/css\">\n" +
                    "p, label, ul, ol, .pre_header { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #000000; cursor: text; }\n" +
                    ".footer p, .footer label, .footer ul, .footer ol { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #C88D81; cursor: text; }\n" +
                    "a { text-decoration: none; color: #C88D81; }\n" +
                    "a:hover { text-decoration: none; color: #C88D81; }\n" +
                    "a:visited { text-decoration: none; color: #C88D81; }\n" +
                    ".all_notifications a, #responsive_page_content a { text-decoration: none; color: #FBDFCC; }\n" +
                    ".all_notifications a:hover, #responsive_page_content a:hover { text-decoration: none; color: #FBDFCC; }\n" +
                    ".all_notifications a:visited, #responsive_page_content a:visited { text-decoration: none; color: #FBDFCC; }\n" +
                    ".show_vertical_menu { display: none; }\n" +
                    "#show_vertical_menu { display: none; text-align: right; color: #C88D81; width: 100%; }\n" +
                    "#hide_vertical_menu { display: none; text-align: right; color: #C88D81; width: 100%; }\n" +
                    "#click_show_vertical_menu:hover { cursor: pointer; text-align: right; color: #C88D81; width: 100%; }\n" +
                    "#click_hide_vertical_menu:hover { cursor: pointer; text-align: right; color: #C88D81; width: 100%; }\n" +
                    ".menu_label a { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; }\n" +
                    ".menu_label a:hover { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #FBDFCC; }\n" +
                    ".focused_menu_label a { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #FBDFCC; }\n" +
                    ".focused_menu_label a:hover { font-family: normal normal normal 'Open Sans', sans-serif; font-size: 12pt; color: #FBDFCC; }\n" +
                    ".pre_header a, .content a { text-decoration: none; font-family: normal normal normal 'Open Sans', sans-serif; color: #5A403B; }\n" +
                    ".pre_header a:hover, .content a:hover { text-decoration: underline; }\n" +
                    ".content a:visited { text-decoration: none; font-family: normal normal normal 'Open Sans', sans-serif; color: #5A403B; }\n" +
                    ".foot_label { color: #C88D81; }\n" +
                    ".footer a, .foot_label a { color: #FBDFCC; }\n" +
                    ".footer a:hover, .foot_label a:hover { text-decoration: underline; }\n" +
                    "\n" +
                    ".signature_section {\n" +
                    "\n" +
                    "background-color: #5A403B;\n" +
                    "background-image: -webkit-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "background-image: -moz-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "background-image: -o-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "background-image: repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "-webkit-background-size: 4px 4px;\n" +
                    "-moz-background-size: 4px 4px;\n" +
                    "background-size: 4px 4px;\n" +
                    "}\n" +
                    "\n" +
                    "input { font-family: arial, sans-serif; font-size: 12pt; background-color: #5A403B; color: #FBDFCC; border: 2px solid; padding: 2px; border-color: #5A403B; }\n" +
                    "input[type=text], input[type=password], textarea, select { font-family: arial, sans-serif; font-size: 12pt; background-color: white; color: #5A403B; border: 2px solid; padding: 2px; border-color: #5A403B; }\n" +
                    "input[type=text]:focus, input[type=password]:focus, select:focus, textarea:focus { background-color: white; border-color: #5A403B; color: #5A403B; border: 2px solid; padding: 2px; cursor: pointer; }\n" +
                    "input[type=submit]:hover, input[type=button]:hover, input[type=submit]:focus, input[type=button]:focus { background-color: transparent; border-color: #5A403B; color: #5A403B; border: 2px solid; padding: 2px; cursor: pointer; }\n" +
                    ".header { vertical-align: top; text-align: left; }\n" +
                    "\n" +
                    ".header, body {\n" +
                    "\n" +
                    "background-image: -webkit-repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);\n" +
                    "background-image: -moz-repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);\n" +
                    "background-image: -ms-repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);\n" +
                    "background-image: repeating-radial-gradient(center center, rgba(0,0,0,.2), rgba(0,0,0,.2) 1px, transparent 1px, transparent 100%);\n" +
                    "-webkit-background-size: 3px 3px;\n" +
                    "-moz-background-size: 3px 3px;\n" +
                    "background-size: 3px 3px;\n" +
                    "}\n" +
                    "\n" +
                    ".footer {\n" +
                    "\n" +
                    "background-color: #5a3428;\n" +
                    "background-image: -webkit-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "background-image: -moz-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "background-image: -o-repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "background-image: repeating-linear-gradient(135deg, rgba(0,0,0,.3), rgba(0,0,0,.3) 1px, transparent 2px, transparent 2px, rgba(0,0,0,.3) 3px);\n" +
                    "-webkit-background-size: 4px 4px;\n" +
                    "-moz-background-size: 4px 4px;\n" +
                    "background-size: 4px 4px;\n" +
                    "}\n" +
                    "\n" +
                    "#logo_traditional_and_links_traditional_format, #logo_traditional_and_links_responsive_format { text-transform: uppercase; font-weight: bold; }\n" +
                    "\n" +
                    "textarea, input, select { margin-top: 6px; margin-bottom: 6px; font-size: 12pt; }\n" +
                    "input[type=submit], input[type=button] { margin-top: 6px; margin-bottom: 6px; font-size: 14pt; }\n" +
                    "\n" +
                    ".footer .foot_label { text-align: left; height: 100%; width: auto; word-wrap: break-word; }\n" +
                    "</style>\n" +
                    
                    "<div class=\"pre_header\" style=\"background-color: #FBDFCC; vertical-align: top; text-align: left\">\n" +
                    "</div>\n" +
                    "<div class=\"header\" style=\"background-color: #5A403B; vertical-align: top; text-align: left\">\n" +
                    "<div id=\"logo_traditional_and_links_traditional_format\">\n" +
                    "<div style=\"display: table; text-align: left; width: 80%; padding-top: 15px; padding-bottom: 15px; margin-left: 10%; margin-right: 10%\">\n" +
                    "<div style=\"display: table-row; text-align: left; width: 100%;\">\n" +
                    "<div style=\"display: table-cell; text-align: left; width: 30%;\">\n" +
                    Request_Website_Logo.request_website_logo() + "\n" +
                    "</div>\n" +
                    "<div style=\"display: table-cell; text-align: right; width: 70%; vertical-align: middle; word-wrap: break-word\">\n" +
                    "<div style='text-align: right; vertical-align: top; width: 100%'><p>\n" +
                    Request_Website_Links.request_website_links_horizontal_format() + "\n" +
                    "</p></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div id=\"logo_traditional_and_links_responsive_format\">\n" +
                    "<div style=\"display: table; text-align: left; width: 98%; padding-top: 15px; padding-bottom: 15px; margin-left: 1%; margin-right: 1%\">\n" +
                    "<div style=\"display: table-row; text-align: left; width: 100%;\">\n" +
                    "<div style=\"display: table-cell; text-align: left; vertical-align: center; width: 50%;\">\n" +
                    Request_Website_Logo.request_website_logo() + "\n" +
                    "</div>\n" +
                    "<div style=\"display: table-cell; text-align: right; width: 50%; vertical-align: middle\">\n" +
                    "<div id=\"show_vertical_menu\">\n" +
                    "<p><b><a id=\"click_show_vertical_menu\" onclick=\"onclick_show_vertical_menu()\">\n" +
                    "<div style=\"display: table; width: 100%; text-align: right\">\n" +
                    "<div style=\"display: table-row; text-align: right\">\n" +
                    "<div style=\"display: table-cell; text-align: right\">___</div></div></div>\n" +
                    "<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">\n" +
                    "<div style=\"display: table-row; text-align: right\">\n" +
                    "<div style=\"display: table-cell; text-align: right\">___</div></div></div>\n" +
                    "<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">\n" +
                    "<div style=\"display: table-row; text-align: right\">\n" +
                    "<div style=\"display: table-cell; text-align: right\">___</div></div></div></a></b></p>\n" +
                    "</div>\n" +
                    "<div id=\"hide_vertical_menu\">\n" +
                    "<p><b><a id=\"click_hide_vertical_menu\" onclick=\"onclick_hide_vertical_menu()\">\n" +
                    "<div style=\"display: table; width: 100%; text-align: right\">\n" +
                    "<div style=\"display: table-row; text-align: right\">\n" +
                    "<div style=\"display: table-cell; text-align: right\">___</div></div></div>\n" +
                    "<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">\n" +
                    "<div style=\"display: table-row; text-align: right\">\n" +
                    "<div style=\"display: table-cell; text-align: right\">___</div></div></div>\n" +
                    "<div style=\"display: table; width: 100%; text-align: right; margin-top: -10px\">\n" +
                    "<div style=\"display: table-row; text-align: right\">\n" +
                    "<div style=\"display: table-cell; text-align: right\">___</div></div></div></a></b></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div style=\"display: table; text-align: left; width: 98%; margin-left: 1%; margin-right: 1%\">\n" +
                    "<div style=\"display: table-row; text-align: left; width: 100%;\">\n" +
                    "<div style=\"display: table-cell; text-align: left; width: 100%; word-wrap: break-word\">\n" +
                    "<script type=\"text/javascript\">\n" +
                    "$(document).ready(function() {\n" +
                    "\n" +
                    "$(\"#show_vertical_menu\").fadeIn();\n" +
                    "});\n" +
                    "\n" +
                    "function onclick_show_vertical_menu() {\n" +
                    "\n" +
                    "$(\".show_vertical_menu\").slideDown(1200);\n" +
                    "$(\"#hide_vertical_menu\").slideDown(1200);\n" +
                    "$(\"#show_vertical_menu\").slideUp(1200);\n" +
                    "}\n" +
                    "\n" +
                    "function onclick_hide_vertical_menu() {\n" +
                    "" +
                    "$(\".show_vertical_menu\").slideUp(1200);\n" +
                    "$(\"#show_vertical_menu\").slideDown(1200);\n" +
                    "$(\"#hide_vertical_menu\").slideUp(1200);\n" +
                    "}\n" +
                    "</script>\n" +
                    Request_Website_Links.request_website_links_vertical_format() + "\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div class=\"content\" style=\"vertical-align: top; text-align: left\">\n" +
                    Request_Web_Page.request_content() + "\n" +
                    "</div>\n" +
                    "<div class=\"footer\" style=\"text-align: left; word-wrap: break-word\">\n" +
                    Request_Footer_Content.request_footer_content() + "\n" +
                    "<div class=\"signature_section\">\n" +
                    "<div id=\"footer_traditional_format\">\n" +
                    "<div style=\"text-align: left; width: 80%; margin-left: 10%; margin-right: 10%; padding-top: 15px; padding-bottom: 10px;\">\n" +
                    "<span class=\"foot_label\">Powered by <b><a href=\"http://www.timothysdigitalsolutions.com/\">Timothy's Digital Solutions</a> Framework</b></span>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<div id=\"footer_responsive_format\">\n" +
                    "<div style=\"text-align: center; width: 98%; margin-left: 1%; margin-right: 1%; padding-top: 15px; padding-bottom: 20px;\">\n" +
                    "<span class=\"foot_label\">Powered by <b><a href=\"http://www.timothysdigitalsolutions.com/\">Timothy's Digital Solutions</a> Framework</b></span>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n";
        } catch (IOException e) {
            
            return "";
        }
    }
	
    public static void main(String[] args) throws Exception, IOException {
		
        SpringApplication.run(Web_Page.class, args);
    }
}
