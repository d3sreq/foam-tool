package org.foam.cli.tools.report.pages

import org.eclipse.xtend.lib.annotations.Data

@Data
class PageTemplate {
	def printPage(CharSequence css, CharSequence menu, CharSequence content) '''
	<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<title>FOAM tool</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta name="description" content="">
			<meta name="author" content="">
			
			<!-- Le styles -->
			<link href="../assets/css/bootstrap.css" rel="stylesheet">
			<style type="text/css">
				body {
					padding-top: 60px;
					padding-bottom: 40px;
				}
				.sidebar-nav {
					padding: 9px 0;
				}
				
				@media (max-width: 980px) {
					/* Enable use of floated navbar text */
					.navbar-text.pull-right {
						float: none;
						padding-left: 5px;
						padding-right: 5px;
					}
				}					
				.scenario { counter-reset: list1 0; list-style-type: none; margin-left: 0px }
				.scenario li { counter-increment: list1 }
				.scenario li:before { margin-right: 10px }
				.main li:before { content: counter(list1) '.' }
				.annot { font-weight: bold; color: blue }
				.loop { font-weight: bold; color: green }
				.usecase-header-block { margin-bottom: 14px }
				.tracecell { padding-left: 10px }
				h2 { font-size: 24.5px }
				«css»
			</style>
			<link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
			
		    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		    <!--[if lt IE 9]>
				<script src="../assets/js/html5shiv.js"></script>
			<![endif]-->
			
			<!-- Fav and touch icons -->
			<link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
			<link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
			<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
			<link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
			<link rel="shortcut icon" href="../assets/ico/favicon.png">
		</head>
		
		<body>
		
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="brand" href="#">FOAM tool report</a>
					<div class="nav-collapse collapse">
						<p class="navbar-text pull-right">
							<!-- Logged in as <a href="#" class="navbar-link">Username</a> -->
						</p>
					</div><!--/.nav-collapse -->
				</div>
			</div>
		</div>
		
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div class="well sidebar-nav">
						<ul class="nav nav-list">
							<!--<li class="nav-header">Sidebar</li>-->
							«menu»
						</ul>
					</div><!--/.well -->
				</div><!--/span-->
				<div class="span9">
					«content»
««« TODO - image + image map
						<div class="uc-image">
						</div>
««« TODO - image - END
				</div><!--/span-->
			</div><!--/row-->  
			
			<hr>
			
			</div><!--/.fluid-container-->
			
			<!-- Le javascript
			================================================== -->
			<!-- Placed at the end of the document so the pages load faster -->
			<script src="../assets/js/jquery.js"></script>
			<script src="../assets/js/bootstrap.min.js"></script>
			<!--
			<script src="../assets/js/bootstrap-transition.js"></script>
			<script src="../assets/js/bootstrap-alert.js"></script>
			<script src="../assets/js/bootstrap-modal.js"></script>
			<script src="../assets/js/bootstrap-dropdown.js"></script>
			<script src="../assets/js/bootstrap-scrollspy.js"></script>
			<script src="../assets/js/bootstrap-tab.js"></script>
			<script src="../assets/js/bootstrap-tooltip.js"></script>
			<script src="../assets/js/bootstrap-popover.js"></script>
			<script src="../assets/js/bootstrap-button.js"></script>
			<script src="../assets/js/bootstrap-collapse.js"></script>
			<script src="../assets/js/bootstrap-carousel.js"></script>
			<script src="../assets/js/bootstrap-typeahead.js"></script>
			-->
		</body>
	</html>
	'''
}
