$(function () {

    'use strict';

    $('html').removeClass('no-js');

    var $btnNavTop = $('.btn-nav-top'),
			$btnNavHeader = $('.btn-nav-header');

    $('body').on('click', '.btn-nav-top', function () {
        if ($btnNavHeader.hasClass('click')) $btnNavHeader.trigger('click');

        $(this).toggleClass('click')
			.find('.icon-arrow-down')
				.toggleClass('icon-arrow-up');
        $('.nav-top').toggle();
    }).on('click', '.btn-search', function () {
        $(this).toggleClass('click')
               .find('.icon-arrow-down')
			   .toggleClass('icon-arrow-up');

        $('#search-container, .nav-search .form-search').toggleClass('hidden');
        $('.btn-country').removeClass('click').find('.icon-arrow-down').removeClass('icon-arrow-up');
        $('.nav-country .subnav').hide();


    }).on('click', '.btn-country', function () {
        $(this).toggleClass('click')
               .find('.icon-arrow-down')
			   .toggleClass('icon-arrow-up');

        $('.nav-country .subnav').toggle();
        $('.btn-search').removeClass('click').find('.icon-arrow-down').removeClass('icon-arrow-up');
        $('#search-container, .nav-search .form-search').addClass('hidden');

    }).on('click', '.btn-lang', function () {
        $(this).toggleClass('click')
			.next('ul').toggle();

        $(this).find('.icon-arrow-down')
			   .toggleClass('icon-arrow-up');
    }).on('mouseleave', '#nav-country', function () {
        $('.btn-country').toggleClass('click');
        $('.nav-country .subnav').toggle();
    });

    //	.on('click', function(e) {
    //		var $target = $('#search-container, .btn-search');
    //
    //		if ($target.hasClass('click') && !$target.is(e.target) && $target.has(e.target).length === 0) {
    //			$('.btn-search').trigger('click');
    //		}
    //	})

    $('.nav-header').on('click', '.btn-nav-header', function () {
        if ($btnNavTop.hasClass('click')) $btnNavTop.trigger('click');

        $(this).toggleClass('click')
			.find('.icon-arrow-down')
				.toggleClass('icon-arrow-up');
        $('.nav-header ul').toggle();
    }).on('click', 'a', function () {
        if ($(this).next('.subnav').length) {
            $(this)
				.find('.icon-plus').toggleClass('icon-close').end()
				.next('.subnav').toggle();
        }
    });


    $('.link-voltar').on('click', function (e) {
        e.preventDefault();
        window.history.back();
    });

    $('form').each(function () {
        $(this).validate({
            errorPlacement: function (error, element) { return true; }
        });
    });

    $('.lt-ie9 #header-container').append('<div class="before"></div>');


    inputMasks();

    responsive();
    $(window).resize(responsive);

    fixIe();

});

$(window).load(function () {
    flexslider();
});

function flexslider() {
    $('.banner').flexslider({
        animation: 'slide',
        animationLoop: false,
        controlNav: false,
        slideshow: false,
        prevText: '<i class="icon-lt"></i>',
        nextText: '<i class="icon-gt"></i>'
    });

    var $sliderAplicacoes = $('.slider');
    $sliderAplicacoes.flexslider({
        animation: 'slide',
        animationLoop: false,
        controlNav: false,
        directionNav: false,
        slideshow: false,
        sync: '.carousel',
        smoothHeight: true,
        start: function (flex) {
            $('.select-aplicacoes > span').html($('.nav-aplicacoes option:selected').text());
            $('.nav-aplicacoes').on('change', function () {
                $(this).parent().find('span').html($(this).find('option:selected').text());
                $('.slider-aplicacoes').flexslider(parseInt($(this).val()));
            });
        }
    });

    if (typeof mqMd === 'undefined' || mqMd.matches || $('.lt-ie9').length > 0) {
        var $recomendados = $('.recomendados-in');
        $recomendados.flexslider({
            animation: "slide",
            animationLoop: false,
            slideshow: false,
            itemWidth: 390,
            itemMargin: 30,
            minItems: 0,
            maxItems: 3,
            controlNav: false,
            prevText: '<i class="icon-arrow-left"></i>',
            nextText: '<i class="icon-arrow-right"></i>'
        });
    }

    var $perguntas = $('.produtos-perguntas');
    $perguntas.flexslider({
        animation: "slide",
        animationLoop: false,
        itemWidth: 200,
        itemMargin: 0,
        minItems: 1,
        maxItems: 1,
        prevText: '<i class="icon-arrow-left"></i>',
        nextText: '<i class="icon-arrow-right"></i>'
    });

    var $videos = $('.produtos-videos');
    $videos.flexslider({
        animation: "slide",
        animationLoop: false,
        slideshow: false,
        itemWidth: 0,
        itemMargin: 0,
        minItems: 1,
        maxItems: 1,
        prevText: '<i class="icon-arrow-left"></i>',
        nextText: '<i class="icon-arrow-right"></i>'
    });

    var $obras = $('.obras-slider');
    $obras.flexslider({
        animation: "slide",
        animationLoop: false,
        itemWidth: 200,
        itemMargin: 0,
        minItems: 1,
        maxItems: 1,
        prevText: '<i class="icon-arrow-left"></i>',
        nextText: '<i class="icon-arrow-right"></i>'
    });

    var $obraDetalheCarousel = $('.obra-detalhe-carousel');
    $obraDetalheCarousel.flexslider({
        animation: "slide",
        controlNav: false,
        animationLoop: false,
        slideshow: false,
        itemWidth: 80,
        itemMargin: 0,
        minItems: 0,
        maxItems: 4,
        asNavFor: '.obra-detalhe-slider',
        prevText: '<i class="icon-arrow-left"></i>',
        nextText: '<i class="icon-arrow-right"></i>'
    });

    var $obraDealheSlider = $('.obra-detalhe-slider');
    if (typeof mqMd === 'undefined' || mqMd.matches) {

        $obraDealheSlider.flexslider({
            animation: "fade",
            animationLoop: false,
            slideshow: false,
            controlNav: false,
            directionNav: false,
            sync: ".obra-detalhe-carousel"
        });

    } else {
        $obraDealheSlider.flexslider({
            animation: "slide",
            controlNav: true,
            directionNav: true,
            prevText: '<i class="icon-arrow-left"></i>',
            nextText: '<i class="icon-arrow-right"></i>'
        });

        $obraDealheSlider.addClass('flex-custom');

        $obraDetalheCarousel.addClass('hide');
    }

    if ((typeof mqMd !== 'undefined' && mqMd.matches) || $('.lt-ie9').length > 0) {

        var $aplicacoes = $('.produtos-aplicacoes');
        $aplicacoes.flexslider({
            animation: "slide",
            animationLoop: false,
            slideshow: false,
            itemWidth: 0,
            itemMargin: 0,
            minItems: 1,
            maxItems: 1,
            prevText: '<i class="icon-arrow-left"></i>',
            nextText: '<i class="icon-arrow-right"></i>'
        });

    }

    var $carousel = $('.carousel:not(.carousel-produtos)'),
			carouselSettings = {
			    animation: 'slide',
			    animationLoop: false,
			    asNavFor: '.slider',
			    controlNav: false,
			    directionNav: true,
			    itemWidth: 210,
			    itemMargin: 0,
			    slideshow: false,
			    start: function (flex) {
			        var maxHeight = 0, slides = flex.find('.slides li');

			        slides.each(function () {
			            if ($(this).height() > maxHeight)
			                maxHeight = $(this).height();
			        });

			        slides.height(maxHeight);
			    }
			};
    if (typeof mqMd === 'undefined' || mqMd.matches) {
        carouselSettings.maxItems = 7;
        carouselSettings.minItems = 1;
    }
    var $cloneCarousel = false;
    $carousel.flexslider(carouselSettings)
		.find('.flex-viewport li').on('click touchstart', function () {
		    if (typeof mqMd === 'undefined' || !mqMd.matches) { // corrigir no ie9 pra baixo
		        if (!$cloneCarousel) {
		            $cloneCarousel = $(this).parent().clone();

		            $carousel.find('i').addClass('icon-arrow-up');
		            $cloneCarousel.addClass('options').appendTo($carousel)
						.find('li').on('click touchstart', function () {
						    $slider.flexslider($(this).index());
						    $carousel.find('i').removeClass('icon-arrow-up');
						    $cloneCarousel.remove();
						    $cloneCarousel = false;
						});
		        } else {
		            $carousel.find('i').removeClass('icon-arrow-up');
		            $cloneCarousel.remove();
		            $cloneCarousel = false;
		        }
		    }
		});
}
var geoLocation = function (location) {
    var object = {
        settings: {
            zoom: 3,
            symbols: {
                /*default: 'images/icon/icon-pin.png'*/
            },
        },
        map: {},
        init: function (location) {
            var map = document.getElementById('map');

            if (map !== null) {
                this.map = new google.maps.Map(map, {
                    zoom: this.settings.zoom,
                    scrollwheel: false,
                    navigationControl: false,
                    mapTypeControl: false,
                    scaleControl: false,
                    draggable: false,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                });

                var marker = this.addMarker(location);
                this.map.setCenter(marker.getPosition());
            }

            return this;
        },
        addMarker: function (location) {
            if (location.length) {
                var point = new google.maps.LatLng(location[0], location[1]),
						marker = new google.maps.Marker({
						    map: this.map,
						    position: point,
						    draggable: false,
						    icon: this.settings.symbols[location[2]]
						});

                google.maps.event.addListener(marker, 'click', function () {
                    if (this.map.getZoom() == object.settings.zoom)
                        this.map.setZoom(15);
                    else this.map.setZoom(object.settings.zoom);

                    this.map.setCenter(marker.getPosition());
                });

                return marker;
            }
        }
    };

    return object.init(location);
};

function inputMasks() {
    $('input.tel').focus(function () {
        $(this).mask('(99) 9999-9999?9', {
            completed: function () {
                $(this).mask('(99) 99999-9999');
            }
        });
    });
    $('input.cep').mask('99999-999');
}

function responsive() {
    $('[data-bg-sm],[data-bg-md],[data-bg-lg]').css('background-image', dataBackgroundImage);
    $('[data-img-src]').each(dataImgSrc);
}

function fixIe() {
    $('.lt-ie10 [placeholder]').focus(placeholderFocus).blur(placeholderBlur).trigger('blur');
    $('.lt-ie10 [placeholder]').parents('form').submit(placeholderSubmit);
}

function dataBackgroundImage() {
    var data;

    if ((typeof mqMd === 'undefined' || mqMd.matches) && typeof $(this).attr('data-bg-md') !== 'undefined') {
        data = $(this).attr('data-bg-md');
    }
    if ((typeof mqLg === 'undefined' || mqLg.matches) && typeof $(this).attr('data-bg-lg') !== 'undefined') {
        data = $(this).attr('data-bg-lg');
    }

    if (typeof $(this).attr('data-bg') !== 'undefined' && $('.lt-ie9').length > 0) {
        data = $(this).attr('data-bg');
    }

    if (typeof data !== 'undefined')
        return ['url(', data, ')'].join('');
    else return 'none';
}

function dataImgSrc() {
    var img_src = $(this).attr('data-img-src'),
		img_alt = $(this).text();

    $(this)
		.removeAttr('data-img-src')
		.append(['<img src="', img_src, '" alt="', img_alt, '"/>'].join(''));
}

function placeholderFocus() {
    var input = $(this);
    if (input.val() == input.attr('placeholder')) {
        input.val('');
        input.removeClass('placeholder');

        if (input.hasClass('password'))
            input.attr('type', 'password').removeClass('password');
    }
}

function placeholderBlur() {
    var input = $(this);
    if (input.val() == '' || input.val() == input.attr('placeholder')) {
        input.addClass('placeholder');
        input.val(input.attr('placeholder'));

        if (input.attr('type') == 'password')
            input.attr('type', 'text').addClass('password');
    }
}

function placeholderSubmit() {
    $(this).find('[placeholder]').each(placeholderEach);
}

function placeholderEach() {
    var input = $(this);
    if (input.val() == input.attr('placeholder'))
        input.val('');
}

function setCookie(name, value, days) {
    var date = new Date();
    date.setDate(date.getDate() + days);

    var cookie = escape(value) + ((days == null) ? '' : '; expires=' + date.toUTCString());
    document.cookie = name + '=' + cookie;
}

function getCookie(name) {
    var cookie = document.cookie;
    var start = cookie.indexOf(' ' + name + '=');

    if (start == -1) {
        start = cookie.indexOf(name + '=');
    }

    if (start == -1) {
        cookie = null;
    } else {
        start = cookie.indexOf('=', start) + 1;

        var end = cookie.indexOf(';', start);

        if (end == -1) {
            end = cookie.length;
        }

        cookie = unescape(cookie.substring(start, end));
    }

    return cookie;
}

function changeInputAssunto(value) {

    var value = value;
    var assunto = $('#Eassunto');

    $('.contato-content-nav li').toggleClass('active');

    assunto.empty();

    if (value == 'vendas') {
        assunto.append('<option value="">Selecione</option>');
        assunto.append('<option value="1">Pedir InformaÃ§Ãµes</option>');
        assunto.append('<option value="1">Outros</option>');
    }
    else {
        assunto.append('<option value="">Selecione2</option>');
        assunto.append('<option value="1">Pedir InformaÃ§Ãµes2</option>');
        assunto.append('<option value="1">Outros2</option>');
    }

}

$('#Epais').change(function () {
    var value = $(this).val();
    if (value) {
        $.ajax({
            url: ['vendedores.php?cod=', value].join(''),
            type: 'get',
            beforeSend: function () {
                $('#vendedores').html('<div class="loader"></div>');
            },
            success: function (data) {
                $('#vendedores').html(data);
            },
            error: function () {
                $('#vendedores').html('<p>Erro ao enviar dados! Por favor, recarregue a pÃ¡gina e tente novamente.</p>');
            }
        });
    }
});

function carouselProdutos() {

    var $window = $(window),
			flexslider;

    function getGridSize() {
        return (window.innerWidth < 600) ? 2 :
					 (window.innerWidth < 900) ? 3 : 4;
    }

    $(function () {
        SyntaxHighlighter.all();
    });

    $window.load(function () {
        $('.flexslider2').flexslider({
            animation: "slide",
            animationLoop: false,
            itemWidth: 210,
            itemMargin: 5,
            minItems: getGridSize(), // use function to pull in initial value
            maxItems: getGridSize() // use function to pull in initial value
        });
    });

    $window.resize(function () {
        var gridSize = getGridSize();

        flexslider.vars.minItems = gridSize;
        flexslider.vars.maxItems = gridSize;
    });

}

if ($('#obras')[0]) {
    qtdeItensObras();
}

function qtdeItensObras() {
    var itens;

    changeSlider();
    window.onresize = changeSlider;

    function changeSlider() {
        if (typeof mqMd === 'undefined' || mqMd.matches) { // Corrigir no ie9 para baixo
            itensObras = 3;
        }
        if (typeof mq992 === 'undefined' || mq992.matches) { // Corrigir no ie9 para baixo
            itensObras = 7;
        }
        if (typeof mqLg === 'undefined' || mqLg.matches) { // Corrigir no ie9 para baixo
            itensObras = 10;
        };
    }

    document.getElementById('qtdeItens').value = itens;

}

if ($('#produtos-in-container')[0]) {
    var mobile = document.getElementById('mobile');
    if (mobile) mobile.value = (typeof mqMd !== 'undefined' ? mqMd.matches : 0);
}

if ($('#produtos-obras')[0]) {
    qtdeItensProdutosObras();
}

function qtdeItensProdutosObras() {
    var itens;

    changeSlider();
    window.onresize = changeSlider;

    function changeSlider() {
        if (mqMd.matches) {
            itensObras = 3;
        }
        if (mq992.matches) {
            itensObras = 6;
        }
        if (mqLg.matches) {
            itensObras = 6;
        };
    }

    document.getElementById('qtdeItens').value = itens;

}


function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
}