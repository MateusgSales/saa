package br.unifor.pin.saa.aspectj;


import javassist.bytecode.SignatureAttribute.MethodSignature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(LoggerAspect.class);

	@Around("@within(Loggable) || @annotation(Loggable)")
	public Object logBefore(final ProceedingJoinPoint joinPoint)
			throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Loggable loggable = signature.getMethod().getAnnotation(Loggable.class) != null ? signature
				.getMethod().getAnnotation(Loggable.class) : signature
				.getMethod().getDeclaringClass().getAnnotation(Loggable.class);

		if (loggable.enable()) {
			logger.debug("Inicio: class=["
					+ joinPoint.getTarget().getClass().getName()
					+ "] method: [" + joinPoint.getSignature().getName() + "]");
		}
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			if (loggable.enable()) {
				logger.error("Exceção: class=["
						+ joinPoint.getTarget().getClass().getName()
						+ "] method: [" + joinPoint.getSignature().getName()
						+ "]" + e.getMessage() + e.getStackTrace());
			}
			throw e;
		}
		if (loggable.enable()) {
			logger.debug("Fim: class=["
					+ joinPoint.getTarget().getClass().getName()
					+ "] method: [" + joinPoint.getSignature().getName() + "]");
		}

		return obj;
	}
}
