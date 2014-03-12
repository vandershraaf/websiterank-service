WebsiteRank Service
====================

This is a simple REST service for displaying website visitor count. 

Usage
-----

The root URL for all services is http://websiterank.herokuapp.com/services/. Data format is JSON. 


** Visitor service **

> /visits/

-> Display visitor count ranking for all websites in all dates. The list is sorted in descending order by website's visitor count.

> /visits/date/{date}?sortBy=[visit_asc, visit_desc, website_asc, website_desc]

-> Display visitor count ranking in the specified day. sortBy parameters:
-  visit_asc = sort by visitor count, ascending
-  visit_desc = sort by visitor count, descending
-  website_asc = sort by website alphabet, ascending
-  website_desc = sort by website alphabet, descending

-> If no parameter is specified, then the list is sorted by visit_desc

> /visits/website/{website}?sortBy=[visit_asc, visit_desc, date_asc, date_desc]

-> Displays visitor count of specified website. sortBy parameters:
-  visit_asc = sort by visitor count, ascending
-  visit_desc = sort by visitor count, descending
-  date_asc = sort by date, ascending 
-  date_desc = sort by date, descending


** Website service **

> /website/

-> Displays all websites name

** Date visited service **

> /dateVisited/

-> Displays all dates



    