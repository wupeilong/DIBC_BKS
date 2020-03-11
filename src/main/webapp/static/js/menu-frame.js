!function($) {
  "use strict";
  var sidebar = function(element, options) {
    this.options= options;
    this.$sidebar= $(element);  
    this.$body= $('body');
    this.$nav = $('.menu-nav');
    this.$bodyheight =document.body.scrollHeight;
    this.$navheight=$('.menu-content');
    this.$toggle=options.toggle || $('.sidebar-toggle');    
    this.init();
    this.bindEvent();
  };
  sidebar.prototype.init = function() {
    var _this = this;
    _this.bodyheight();
    //默认给body添加sidebar-notransition样式
    _this.$body.addClass('sidebar-notransition');
    //点击收缩侧面菜单栏按钮，收缩侧面菜单栏
    _this.$toggle.on( 'click', function(e) {     
      _this.togglesidebar();
    }); 
    //获取logo图片的点击事件，收缩侧面菜单栏
    $('#sideLogo').on( 'click', function(e) {     
        _this.togglesidebar();
      });     
  }
  sidebar.prototype.isShow = function() {
	    return !this.$body.hasClass('sidebar-hide');
  }
 
  //判断当前侧面菜单栏是否展开
  sidebar.prototype.togglesidebar = function(type) {
    var _this = this;
    var show = !_this.isShow();
    if(type) {
      if((type=='show' && !show)|| (type=='hide' && show)) {
        return;
      }
    }  
    //如果展开的则给body添加sidebar-hide样式缩放，否则移除sidebar-hide
    if( show ) {
    	_this.$body.removeClass('sidebar-hide');
    } else {
    	_this.$body.addClass('sidebar-hide'); 
    }
  } 
  sidebar.prototype.bodyheight=function(){		  
	  if(document.body.clientHeight <document.body.scrollHeight){
		  document.getElementsByTagName("body")[0].style.height = document.body.scrollHeight+"px";
	  }else if(this.$navheight.height() > this.$bodyheight && this.$navheight.height() <= document.body.clientHeight){
		  document.getElementsByTagName("body")[0].style.height = this.$navheight.height()+"px";
	  }else{
		  document.getElementsByTagName("body")[0].style.height="100%";
	  }
  }
  //ul点击事件
  sidebar.prototype.bindEvent = function(){
		var _this= this;		
		this.$nav.on('click', 'li', function(){			
			if($(this).hasClass('active')){
				return false;	
			}
			$(this).addClass('active').siblings().removeClass("active").find(".subnav").hide().end().end().find(".subnav").show();	
			_this.bodyheight();						
		});		
  }

  $('.sidebar').each(function() {
    var options = $.extend({}, $(this).data(), typeof option == 'object' && option);
    var cursidebar = new sidebar(this, options);
  });
}(jQuery);